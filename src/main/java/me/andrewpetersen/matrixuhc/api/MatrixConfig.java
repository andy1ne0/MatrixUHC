package me.andrewpetersen.matrixuhc.api;

/*
 * This project has been written by Andrew Petersen, and anyone who has contributed to the source code
 * (or where otherwise declared). 
 *
 * This code is licensed under the GPLv3 License, a copy of which can be found in the root directory. 
 */

import com.google.common.io.ByteStreams;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.andrewpetersen.matrixuhc.MatrixUHC;
import me.andrewpetersen.matrixuhc.Strings;
import org.apache.commons.lang.Validate;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is a utility class for working with configuration files.
 */
@Getter
@Setter(value = AccessLevel.PRIVATE)
public class MatrixConfig {

    private FileConfiguration config;
    private File file;
    private String fileName;
    private MatrixUHC instance;

    /**
     * Private constructor - we don't want this being called from anywhere, not even internally, hence it'll throw an error.
     */
    private MatrixConfig() {
        throw new IllegalArgumentException("Use of the default MatrixConfig constructor is not allowed! ");
    }

    /**
     * Private constructor - because any Matrix Configurations should be created using the utility method.
     */
    private MatrixConfig(MatrixUHC instance, File file, FileConfiguration config, String fileName) {
        this.setFile(file);
        this.setConfig(config);
        this.setFileName(fileName);
        this.setInstance(instance);
    }

    /**
     * Create a {@link YamlConfiguration} instance for a specified resource file name.
     *
     * @param resourceName The name of the file in the resources folder.
     * @return The YamlConfiguration file.
     */
    public static MatrixConfig createConfiguration(String resourceName) throws IOException {
        Validate.notNull(resourceName, "Can't create a config with the resource name being null!");
        Validate.notNull(MatrixUHC.getInstance().getResource(resourceName), "No resources named \"" + resourceName + "\" were found! ");
        File dataFolder = MatrixUHC.getInstance().getDataFolder();
        if (!dataFolder.exists() && !dataFolder.mkdirs()) {
            throw new IOException("Couldn't create the data folder! ");
        }
        File actualFile = new File(dataFolder, resourceName);
        if (!actualFile.exists()) {
            if (!actualFile.createNewFile()) {
                throw new IOException("Could not create the configuration file \"" + resourceName + "\"!");
            }
            ByteStreams.copy(MatrixUHC.getInstance().getResource(resourceName), new FileOutputStream(actualFile));
        }
        YamlConfiguration defaultsConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(MatrixUHC.getInstance().getResource(resourceName)));
        YamlConfiguration actualConfig = YamlConfiguration.loadConfiguration((actualFile));
        actualConfig.setDefaults(defaultsConfig);
        return new MatrixConfig(MatrixUHC.getInstance(), actualFile, actualConfig, resourceName);
    }

    /**
     * Save the configuration data to disk. This should be called after every modification to the config.
     */
    public void save() {
        Validate.notNull(this.getFileName(), "File name is null!");
        Validate.notNull(this.getConfig(), "Config for \"" + this.getFileName() + "\" is null! ");
        Validate.notNull(this.getFile(), "File for \"" + this.getFileName() + "\" is null! ");
        try {
            this.getConfig().save(this.getFile());
            if (this.getInstance().isVerbose()) {
                this.getInstance().getServer().getLogger().info(Strings.VERBOSE_CONSOLE_PREFIX + "Config \"" + this.getFileName() + "\" was successfully saved. ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is simply a wrapper method for {@link #save()} and {@link #reload()}, seeing as both these methods should typically be used together.
     */
    public void saveAndReload() {
        this.save();
        this.reload();
    }

    /**
     * A method to reload the config. This should typically be called after the {@link #save()} method is called.
     */
    public void reload() {
        Validate.notNull(this.getFile(), "The config's file is null! ");
        Validate.notNull(this.getConfig(), "The config is null! ");
        this.setConfig(YamlConfiguration.loadConfiguration(this.getFile()));
    }

}
