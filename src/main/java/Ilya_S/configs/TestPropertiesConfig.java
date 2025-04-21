package Ilya_S.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties",
        "classpath:config.properties"
})
public interface TestPropertiesConfig extends org.aeonbits.owner.Config  {

    @Key("login")
    String getUsername();

    @Key("password")
    String getPassword();

    @Key("invalidLogin")
    String getInvalidUsername();

    @Key("invalidPassword")
    String getInvalidPassword();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("remoteUrl")
    String remoteUrl();
}
