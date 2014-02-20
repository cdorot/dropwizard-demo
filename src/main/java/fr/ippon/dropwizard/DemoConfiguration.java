package fr.ippon.dropwizard;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

public class DemoConfiguration extends Configuration {

	@Valid
	@NotNull
	@JsonProperty
	private DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();

	public DatabaseConfiguration getDatabaseConfiguration() {
		return databaseConfiguration;
	}

}
