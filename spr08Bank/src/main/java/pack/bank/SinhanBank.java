package pack.bank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sin")
@Scope("prototype") //기본은 singleton
public class SinhanBank implements Bank{
	private int money = 1000;
	
	@Override
	public void inputMoney(int money) {
		this.money = this.money + money;
		
	}
	
	@Override
	public void outputMoney(int money) {
		int imsi = money;
		this.money -= imsi;
		
	}
	
	@Override
	public int getMoney() {
		return money;
		
	}
	
}