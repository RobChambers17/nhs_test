package com.logicbig.example;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.logicbig.example.RegularAmountConstraint;

@RegularAmountConstraint(message = "Generic unhelful failure", notDivisable = "This Amount is incorrect, this could not divide into a weekly figure or is blank")
public class Customer {
    @NotNull
    @Size(min = 5, max = 50)
    private String name;
    @NotNull
    private String amount;
    @NotNull
    private Frequency frequency;
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Frequency getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

}