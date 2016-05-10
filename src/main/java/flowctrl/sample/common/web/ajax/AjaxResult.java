package flowctrl.sample.common.web.ajax;

import org.springframework.core.Conventions;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * Created by allbegray on 2016-05-10.
 */
public class AjaxResult {

    private Result result;
    private String message;
    private List<ErrorMessage> errorMessages = new ArrayList<>();
    private Map<String, Object> parameters = new LinkedHashMap<>();

    public void setMessage(String message) {
        this.message = message;
    }

    private void setResult(Result result) {
        this.result = result;
    }

    private void setErrorMessages(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }

    private AjaxResult() {
    }

    public AjaxResult addAttribute(String attributeName, Object attributeValue) {
        Assert.notNull(attributeName, "Model attribute name must not be null");
        parameters.put(attributeName, attributeValue);
        return this;
    }

    public AjaxResult addAttribute(Object attributeValue) {
        Assert.notNull(attributeValue, "Model object must not be null");
        if (attributeValue instanceof Collection && ((Collection<?>) attributeValue).isEmpty()) {
            return this;
        }
        return addAttribute(Conventions.getVariableName(attributeValue), attributeValue);
    }

    public AjaxResult addAllAttributes(Map<String, ?> attributes) {
        if (attributes != null) {
            parameters.putAll(attributes);
        }
        return this;
    }

    public static AjaxResult jsonWithSuccessResult() {
        AjaxResult map = new AjaxResult();
        map.setResult(Result.success);
        return map;
    }

    public static AjaxResult jsonWithError(String errMessage) {
        AjaxResult map = new AjaxResult();
        map.setResult(Result.failure);
        map.setMessage(errMessage);
        return map;
    }

    public static AjaxResult jsonWithError(Exception exception) {
        return jsonWithError(exception.getMessage());
    }

    public static AjaxResult jsonWithError(BindingResult bindingResult) {
        Assert.isTrue(bindingResult.hasErrors(), "\n\n\tfollow these guidelines.\n\tif (bindingResult.hasErrors()) {\n\t\treturn AjaxResult.jsonWithError(bindingResult);\n\t}\n");

        AjaxResult ajaxResult = jsonWithError(bindingResult.getGlobalError().getDefaultMessage());

        List<FieldError> errors = bindingResult.getFieldErrors();
        List<ErrorMessage> errorMessages = new ArrayList<>();
        for (FieldError error : errors) {
            errorMessages.add(new ErrorMessage(error.getField(), error.getDefaultMessage()));
        }
        ajaxResult.setErrorMessages(errorMessages);

        return ajaxResult;
    }

    private enum Result {
        success, failure
    }

}