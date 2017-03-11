package br.com.test.uesu.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import br.com.duzard.utils.AppContext;

@Configuration
@Import(value = { AppContext.class })
@ComponentScan(basePackages = { "br.com.test.uesu" })
public abstract class AppContextTest {

}
