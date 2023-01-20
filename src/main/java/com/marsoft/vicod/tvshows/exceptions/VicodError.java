package com.marsoft.vicod.tvshows.exceptions;

import java.io.Serializable;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class VicodError implements Serializable {

	private static final long serialVersionUID = 7987922636266460310L;
	
	private String name;
	private String value;

	
	
	public VicodError(final String name, final String value) {
		this.name = name;
		this.value = value;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof VicodError)) {
			return false;
		}
		VicodError castOther = (VicodError) other;
		return new EqualsBuilder().append(name, castOther.name).append(value, castOther.value).isEquals();
	}

	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(value).toHashCode();
	}

	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("value", value).toString();
	}
	
	
	
}