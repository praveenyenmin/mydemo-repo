package jp.co.axa.apidemo.valueobjects;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GenericResponse {

	String message;
	Object data;

}
