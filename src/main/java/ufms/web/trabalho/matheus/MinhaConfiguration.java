package ufms.web.trabalho.matheus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("developer")
public class MinhaConfiguration {

    @Bean("nomeConfiguracao")
    public String hello(){
        return "valor da configuração";
    }

    //@Bean("ufms.matheus.libras.repository.UsuarioRepository")
    //public String teste(){
    //    return null;
    //}

}
