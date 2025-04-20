package configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:default.properties"
})
public interface TestPropertiesConfig extends Config {

    @Key("login")
    String getUsername();

    @Key("password")
    String getPassword();

    @Key("invalidLogin")
    String getInvalidUsername();

    @Key("invalidPassword")
    String getInvalidPassword();
}
