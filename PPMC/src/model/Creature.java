package model;

import java.util.Random;

public abstract class Creature {

	private String name;	
	private float life;
	private float atk;
	private float def;	
		
	public Creature() {

	}
	
	public Creature(String name, float life, float atk, float def) {
		this.name = name;
		this.life = life;
		this.atk = atk;
		this.def = def;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLife() {
		return life;
	}

	public void setLife(float life) {
		this.life = life;
	}

	public float getAtk() {
		return atk;
	}

	public void setAtk(float atk) {
		this.atk = atk;
	}

	public float getDef() {
		return def;
	}

	public void setDef(float def) {
		this.def = def;
	}

	public void attack(Creature target){
		float dmg = target.getDef()-this.atk;
		
		/* 
		 * se não vai dar dano, então tem um chande de errar completamente ou dar 1 de dano
		 * no caso de erro, tem que verificar se a vida vai estar igual ao fim do turno para dar uma mensagem
		 * 
		 */		
		if(dmg <= 0){
			//o +1 é pra evitar divisão por 0
			dmg = (new Random().nextInt(1)+1) % 2 == 0 ? 0 : 1;
		}			
				
		target.setLife(target.getLife()-dmg);		
	}
	
	public void defend(){
		//lembrar de remover a defesa extra após o turno		
		this.def += (this.def/2);
	}
	
	public void clearDefBonus(){
		this.def -= (this.def/2);
	}	
	
	public boolean flee(Creature target){
		/* 
		 * chance de conseguir fugir da batalha ou não
		 * considerando que se o inimigo for mais forte, tem 50% de chance de fugir, senão 75%
		 * 
		 * o +1 é pra ficar mais bonito lol
		 */
		return new Random().nextInt(100)+1 <= (target.getAtk()-this.atk < 0 ? 75 : 50);
	}
}