package za.ac.nwu.project.translator.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.project.repo.config.RepoConfig;

@Import({RepoConfig.class})
@Configuration
public class TranslatorConfig
{

}
