package com.example.SalaryCalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeTaxService {

	@Autowired
	private IncomeTaxRepository incomeTaxRepository;

	public List<IncomeTax> getAllIncomes() {
		return incomeTaxRepository.findAll();
	}

	public IncomeTax getIncomeById(Long id) {
		return incomeTaxRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
	}

	public IncomeTax createIncome(IncomeTax income) {
		return incomeTaxRepository.save(income);
	}

	public IncomeTax updateIncome(Long id, IncomeTax incomeDetails) {
		IncomeTax income = incomeTaxRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		income.setSalary(incomeDetails.getSalary());
		income.sethRA(incomeDetails.gethRA());
		income.sethRA(incomeDetails.gethRA());
		income.sethRA(incomeDetails.gethRA());
		return incomeTaxRepository.save(income);
	}

	public void deleteIncome(Long id) {
		IncomeTax income = incomeTaxRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		incomeTaxRepository.delete(income);
	}

	private static final double CESS_RATE = 0.04;

	public IncomeTax calculateTax(IncomeTax employee) {

		int age = employee.getAge();

		double sal = employee.getSalary();
		double hra = employee.gethRA();
		double lta = employee.getlTA();
		double sa = employee.getsA();

		double gross = sal + hra + lta + sa;
		employee.setGrossSalary(gross);

		double deduction = employee.getDeduction();

		double netSalary = gross - deduction-300000;
		employee.setNetSalary(netSalary);
		long tax = 0;
		long taxAmount = 0;
		long taxLiability = 0;
		long taxPayable = 0;
		long taxableIncome = 0;
		long surCharge = 0;

		if (age < 60) {
			if (netSalary > 300000 && netSalary <= 600000) {
				tax = 5;
				taxAmount = (long) (300000 * 0.05);
				taxableIncome = (long) (netSalary - 300000);
				taxLiability = (long) (taxableIncome * 0.2);
				taxPayable = taxLiability + taxAmount;
				employee.setTax(tax);
				employee.setTaxAmount(taxAmount);
				employee.setTaxLiability(taxLiability);
				employee.setTaxPayable(taxPayable);
			} else if (netSalary > 600000 && netSalary <= 900000) {
				tax = 10;
				taxAmount = (long) (600000 * 0.1);
				taxableIncome = (long) (netSalary - 600000);
				taxLiability = (long) (taxableIncome * 0.2);
				taxPayable = taxLiability + taxAmount;
				employee.setTax(tax);
				employee.setTaxAmount(taxAmount);
				employee.setTaxLiability(taxLiability);
				employee.setTaxPayable(taxPayable);
			} else if (netSalary > 900000 && netSalary <= 1200000) {
				tax = 15;
				taxAmount = (long) (900000 * 0.15);
				taxableIncome = (long) (netSalary - 900000);
				taxLiability = (long) (taxableIncome * 0.2);
				taxPayable = taxLiability + taxAmount;
				employee.setTax(tax);
				employee.setTaxAmount(taxAmount);
				employee.setTaxLiability(taxLiability);
				employee.setTaxPayable(taxPayable);
			} else if (netSalary > 1200000 && netSalary <= 1500000) {
				tax = 20;
				taxAmount = (long) (1200000 * 0.2);
				taxableIncome = (long) (netSalary - 1200000);
				taxLiability = (long) (taxableIncome * 0.2);
				taxPayable = taxLiability + taxAmount;
				employee.setTax(tax);
				employee.setTaxAmount(taxAmount);
				employee.setTaxLiability(taxLiability);
				employee.setTaxPayable(taxPayable);
			} else if (netSalary > 1500000) {
				tax = 30;
				taxAmount = (long) (1500000 * 0.3);
				taxableIncome = (long) (netSalary - 1500000);
				taxLiability = (long) (taxableIncome * 0.2);
				taxPayable = taxLiability + taxAmount;
				employee.setTax(tax);
				employee.setTaxAmount(taxAmount);
				employee.setTaxLiability(taxLiability);
				employee.setTaxPayable(taxPayable);

				if (netSalary > 5000000 && netSalary <= 10000000) {
					surCharge = 10;

					taxPayable = (long) (surCharge * taxAmount * 0.10 + taxLiability);
				} else if (netSalary > 10000000) {
					surCharge = 20;
					taxPayable = (long) (surCharge * taxAmount * 0.20 + taxLiability);

					employee.setTax(tax);
					employee.setSurCharge(surCharge);
					employee.setTaxPayable(taxPayable);
				}
				}
			} else if (age >= 60) {
				if (netSalary > 500000 && netSalary <= 1000000) {
					tax = 5;
					taxAmount = (long) (500000 * 0.1);
					taxableIncome = (long) (netSalary - 500000);
					taxLiability = (long) (taxableIncome * 0.2);
					taxPayable = taxLiability + taxAmount;
					employee.setTax(tax);
					employee.setTaxAmount(taxAmount);
					employee.setTaxLiability(taxLiability);
					employee.setTaxPayable(taxPayable);
				} else if (netSalary > 1000000 && netSalary <= 5000000) {
					tax = 20;
					taxAmount = (long) (1000000 * 0.15);
					taxableIncome = (long) (netSalary - 1000000);
					taxLiability = (long) (taxableIncome * 0.2);
					taxPayable = taxLiability + taxAmount;
					employee.setTax(tax);
					employee.setTaxAmount(taxAmount);
					employee.setTaxLiability(taxLiability);
					employee.setTaxPayable(taxPayable);
				} else if (netSalary > 5000000) {
					tax = 30;
					taxAmount = (long) (5000000 * 0.3);
					taxableIncome = (long) (netSalary - 5000000);
					taxLiability = (long) (taxableIncome * 0.2);
					taxPayable = taxLiability + taxAmount;
					employee.setTax(tax);
					employee.setTaxAmount(taxAmount);
					employee.setTaxLiability(taxLiability);
					employee.setTaxPayable(taxPayable);

					if (netSalary > 5000000 && netSalary <= 10000000) {
						surCharge = 10;

						taxPayable = (long) (surCharge * taxAmount * 0.10 + taxLiability);
					} else if (netSalary > 10000000) {
						surCharge = 20;
						taxPayable = (long) (surCharge * taxAmount * 0.20 + taxLiability);
						employee.setTax(tax);
						employee.setSurCharge(surCharge);
						employee.setTaxPayable(taxPayable);
					}
				}

			}
			// add cess
			double cess = taxPayable * CESS_RATE;
			employee.setCess(cess);
			taxPayable += cess;
			employee.setTaxPayable(taxPayable);

		
		return incomeTaxRepository.save(employee);
	}
	public List<IncomeTax> getAllCalculations() {

		return incomeTaxRepository.findAll();

		}

}
