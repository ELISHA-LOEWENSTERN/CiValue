package com.civalue.jpa;

import java.io.Serializable;
import java.util.Locale;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PhysicalNamingStrategyImpl extends PhysicalNamingStrategyStandardImpl implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final PhysicalNamingStrategyImpl INSTANCE = new PhysicalNamingStrategyImpl();

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		String result = name.getText();
		result = toPlural(result);
		result = addUnderscores(result);
		return new Identifier(result, name.isQuoted());
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		return new Identifier(addUnderscores(name.getText()), name.isQuoted());
	}

	private static String addUnderscores(String name) {
		final StringBuilder buf = new StringBuilder(name.replace('.', '_'));
		for (int i = 1; i < (buf.length() - 1); i++) {
			if (Character.isLowerCase(buf.charAt(i - 1)) && Character.isUpperCase(buf.charAt(i))
					&& Character.isLowerCase(buf.charAt(i + 1))) {
				buf.insert(i++, '_');
			}
		}
		return buf.toString().toLowerCase(Locale.ROOT);
	}

	public static String toPlural(String singular) {
		int len = singular.length();
		String consonants = "bcdfghjklmnpqrstvwxz";
		// Handle ending with "o" (if preceded by a consonant, end with -es, otherwise
		// -s: Potatoes and Radios)
		if (singular.endsWith("o") && consonants.contains(String.valueOf(singular.charAt(len - 2)))) {
			return singular + "es";
		}
		// Handle ending with "y" (if preceded by a consonant, end with -ies, otherwise
		// -s: Companies and Trays)
		if (singular.endsWith("y") && consonants.contains(String.valueOf(singular.charAt(len - 2)))) {
			return singular.substring(0, len - 1) + "ies";
		}
		// Ends with a whistling sound: boxes, buzzes, churches, passes
		if (singular.endsWith("s") || singular.endsWith("sh") || singular.endsWith("ch") || singular.endsWith("x")
				|| singular.endsWith("z")) {
			return singular + "es";
		}
		return singular + "s";
	}
}