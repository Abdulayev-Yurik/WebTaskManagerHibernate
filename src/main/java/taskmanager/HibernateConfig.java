package taskmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import taskmanager.utils.ParserUri;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class HibernateConfig {

	static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";

	static final Properties hibernateProperties = new Properties() {
		{
			setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			setProperty("hibernate.hbm2ddl.auto", "update");
			setProperty("hibernate.show_sql", "true");
			setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate4.SpringSessionContext");
		}
	};

//	@Value("${connection.url}")
//	String dbUrl;
//
//	@Value("${connection.username}")
//	String dbUser;
//
//	@Value("${connection.password}")
//	String dbPass;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ParserUri uri() throws URISyntaxException {
		return new ParserUri(System.getenv("DATABASE_URL"));
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("taskmanager/model");
		sessionFactory.setHibernateProperties( hibernateProperties );
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = null;
		try {
			dataSource = new DriverManagerDataSource(uri().getJDBCUrl(),
					uri().getLogin(),
					uri().getPassword());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		dataSource.setDriverClassName( DRIVER_CLASS_NAME );
		return dataSource;
	}
}
