package com.zyj.jfcs.app.model;
/**
 * 公共参数，与全校全局测算参数有关
 * @author zhouyj
 *	
 */

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "PUB_DATA")
public class PubData {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment" , strategy = "increment")
	private int id;
	
	@Column(name = "YEAR")
	private int year;
	/**
	 * 年度拟拨付总额
	 */
	@Column(name = "MT")
	private BigDecimal mt;
	/**
	 * 全校本年应收金额
	 */
	@Column(name = "RTE")
	private BigDecimal rte;
	/**
	 * 全校本年实收金额
	 */
	@Column(name = "MTE")
	private BigDecimal mte;
	/**
	 * 全校缴费率标准
	 */
	@Column(name = "SJF")
	private BigDecimal sjf;
	/**
	 * 学生经费分割比
	 */
	@Column(name = "U_PER")
	private BigDecimal uper;
	/**
	 * 专业培养费分割比
	 */
	@Column(name = "PPER")
	private BigDecimal pper;
	/**
	 * 公共课经费分割比
	 */
	@Column(name = "C_PER")
	private BigDecimal cper;
	/**
	 * 奖酬金比率
	 */
	@Column(name = "JCJ_PER")
	private BigDecimal jcjper;
	/**
	 * 学生困难补助比率
	 */
	@Column(name = "XSKNBZ_PER")
	private BigDecimal xsknbzper;
	/**
	 * 学生活动经费比率
	 */
	@Column(name = "XSHDJF_PER")
	private BigDecimal xshdjfper;
	/**
	 * 学生奖学金比率
	 */
	@Column(name = "XSJXJ_PER")
	private BigDecimal xsjxjper;
	/**
	 * 教授A系数
	 */
	@Column(name = "TB1_PER")
	private BigDecimal tb1;
	/**
	 * 教授B系数
	 */
	@Column(name = "TB2_PER")
	private BigDecimal tb2;
	/**
	 * 教授C系数
	 */
	@Column(name = "TB3_PER")
	private BigDecimal tb3;
	/**
	 * 教授D系数
	 */
	@Column(name = "TB4_PER")
	private BigDecimal tb4;
	/**
	 * 副教授A系数
	 */
	@Column(name = "TB5_PER")
	private BigDecimal tb5;
	/**
	 * 副教授B系数
	 */
	@Column(name = "TB6_PER")
	private BigDecimal tb6;
	/**
	 * 讲师
	 */
	@Column(name = "TB7_PER")
	private BigDecimal tb7;
	/**
	 * 助理
	 */
	@Column(name = "TB8_PER")
	private BigDecimal tb8;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public BigDecimal getMt() {
		return mt;
	}
	public void setMt(BigDecimal mt) {
		this.mt = mt;
	}
	public BigDecimal getRte() {
		return rte;
	}
	public void setRte(BigDecimal rte) {
		this.rte = rte;
	}
	public BigDecimal getMte() {
		return mte;
	}
	public void setMte(BigDecimal mte) {
		this.mte = mte;
	}
	public BigDecimal getSjf() {
		return sjf;
	}
	public void setSjf(BigDecimal sjf) {
		this.sjf = sjf;
	}
	public BigDecimal getUper() {
		return uper;
	}
	public void setUper(BigDecimal uper) {
		this.uper = uper;
	}
	public BigDecimal getPper() {
		return pper;
	}
	public void setPper(BigDecimal pper) {
		this.pper = pper;
	}
	public BigDecimal getJcjper() {
		return jcjper;
	}
	public void setJcjper(BigDecimal jcjper) {
		this.jcjper = jcjper;
	}
	public BigDecimal getXsknbzper() {
		return xsknbzper;
	}
	public void setXsknbzper(BigDecimal xsknbzper) {
		this.xsknbzper = xsknbzper;
	}
	public BigDecimal getXshdjfper() {
		return xshdjfper;
	}
	public void setXshdjfper(BigDecimal xshdjfper) {
		this.xshdjfper = xshdjfper;
	}
	public BigDecimal getXsjxjper() {
		return xsjxjper;
	}
	public void setXsjxjper(BigDecimal xsjxjper) {
		this.xsjxjper = xsjxjper;
	}
	public BigDecimal getTb1() {
		return tb1;
	}
	public void setTb1(BigDecimal tb1) {
		this.tb1 = tb1;
	}
	public BigDecimal getTb2() {
		return tb2;
	}
	public void setTb2(BigDecimal tb2) {
		this.tb2 = tb2;
	}
	public BigDecimal getTb3() {
		return tb3;
	}
	public void setTb3(BigDecimal tb3) {
		this.tb3 = tb3;
	}
	public BigDecimal getTb4() {
		return tb4;
	}
	public void setTb4(BigDecimal tb4) {
		this.tb4 = tb4;
	}
	public BigDecimal getTb5() {
		return tb5;
	}
	public void setTb5(BigDecimal tb5) {
		this.tb5 = tb5;
	}
	public BigDecimal getTb6() {
		return tb6;
	}
	public void setTb6(BigDecimal tb6) {
		this.tb6 = tb6;
	}
	public BigDecimal getTb7() {
		return tb7;
	}
	public void setTb7(BigDecimal tb7) {
		this.tb7 = tb7;
	}
	public BigDecimal getTb8() {
		return tb8;
	}
	public void setTb8(BigDecimal tb8) {
		this.tb8 = tb8;
	}
	public BigDecimal getCper() {
		return cper;
	}
	public void setCper(BigDecimal cper) {
		this.cper = cper;
	}
}
