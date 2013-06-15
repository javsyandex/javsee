/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.testwarehouse.shumenko.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.testwarehouse.shumenko.model.entity.IncomingDocument;

/**
 *
 * @author miha
 */
@Component("incomingValidator")
public class IncomingValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return IncomingDocument.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deliveryDate", "label.validate.dateEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shipper", "label.validate.shipperEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "warehouse", "label.validate.warehouseEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "product", "label.validate.productEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "label.validate.amountEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "label.validate.priceEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amountToBePaid", "label.validate.amountToBePaidEmpty");
    }
    
}
