package com.example.SalaryCalculator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "income")
public class IncomeTax {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int Age;

	private double salary;

	private double hRA;

	private double lTA;

	private double sA;
	
	private double grossSalary;
	
	private double deduction;
	
	private double netSalary;

	private long taxAmount;
	
	private long tax;
	
	private long taxPayable;
	
	private long taxLiability;
	
	private double cess;
	
	private long surCharge;

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		this.Age = age;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public double gethRA() {
		return hRA;
	}


	public void sethRA(double hRA) {
		this.hRA = hRA;
	}


	public double getlTA() {
		return lTA;
	}


	public void setlTA(double lTA) {
		this.lTA = lTA;
	}


	public double getsA() {
		return sA;
	}


	public void setsA(double sA) {
		this.sA = sA;
	}


	public double getGrossSalary() {
		return grossSalary;
	}


	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}


	public double getDeduction() {
		return deduction;
	}


	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}


	public double getNetSalary() {
		return netSalary;
	}


	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}


	public long getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(long taxAmount) {
		this.taxAmount = taxAmount;
	}


	public long getTax() {
		return tax;
	}


	public void setTax(long tax) {
		this.tax = tax;
	}


	public long getTaxPayable() {
		return taxPayable;
	}


	public void setTaxPayable(long taxPayable) {
		this.taxPayable = taxPayable;
	}


	public long getTaxLiability() {
		return taxLiability;
	}


	public void setTaxLiability(long taxLiability) {
		this.taxLiability = taxLiability;
	}


	public double getCess() {
		return cess;
	}


	public void setCess(double cess) {
		this.cess = cess;
	}


	public long getSurCharge() {
		return surCharge;
	}


	public void setSurCharge(long surCharge) {
		this.surCharge = surCharge;
	}


	/**
	 * @param id
	 * @param age
	 * @param salary
	 * @param hRA
	 * @param lTA
	 * @param sA
	 * @param grossSalary
	 * @param deduction
	 * @param netSalary
	 * @param taxAmount
	 * @param tax
	 * @param taxPayable
	 * @param taxLiability
	 * @param cess
	 * @param surCharge
	 */
	public IncomeTax(Long id, int age, double salary, double hRA, double lTA, double sA, double grossSalary,
			double deduction, double netSalary, long taxAmount, long tax, long taxPayable, long taxLiability,
			double cess, long surCharge) {
		super();
		this.id = id;
		this.Age = age;
		this.salary = salary;
		this.hRA = hRA;
		this.lTA = lTA;
		this.sA = sA;
		this.grossSalary = grossSalary;
		this.deduction = deduction;
		this.netSalary = netSalary;
		this.taxAmount = taxAmount;
		this.tax = tax;
		this.taxPayable = taxPayable;
		this.taxLiability = taxLiability;
		this.cess = cess;
		this.surCharge = surCharge;
	}


	public IncomeTax() {
		super();
		// TODO Auto-generated constructor stub
	}

}
