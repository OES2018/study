package zh;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChessPieces {
	//ÆåÅÌ
    private BufferedImage table;
	//ºÚ×Ó
	private BufferedImage blackcar,blackhorse,blackelephant,blackgenera,blackofficia,blackcannon,blacksoldier;
	//ºì×Ó
	private BufferedImage redcar,redhorse,redelephant,redgenera,redofficia,redcannon,redsoldier;
	
	public ChessPieces() throws IOException {
		super();
		this.table = ImageIO.read(new File("image/main.gif"));
		this.blackcar = ImageIO.read(new File("image/ºÚ³µ.gif"));
		this.blackhorse = ImageIO.read(new File("image/ºÚÂí.gif"));
		this.blackelephant = ImageIO.read(new File("image/ºÚÏó.gif"));
		this.blackgenera = ImageIO.read(new File("image/ºÚ½«.gif"));
		this.blackofficia =ImageIO.read(new File("image/ºÚÊ¿.gif"));
		this.blackcannon = ImageIO.read(new File("image/ºÚÅÚ.gif"));
		this.blacksoldier = ImageIO.read(new File("image/ºÚ×ä.gif"));
		this.redcar =ImageIO.read(new File("image/ºì³µ.gif"));
		this.redhorse = ImageIO.read(new File("image/ºìÂí.gif"));
		this.redelephant = ImageIO.read(new File("image/ºìÏó.gif"));
		this.redgenera = ImageIO.read(new File("image/ºì½«.gif"));
		this.redofficia = ImageIO.read(new File("image/ºìÊ¿.gif"));
		this.redcannon = ImageIO.read(new File("image/ºìÅÚ.gif"));
		this.redsoldier =ImageIO.read(new File("image/ºì×ä.gif"));
	}
	//ÊôÐÔ
	public BufferedImage getTable() {
		return table;
	}



	public void setTable(BufferedImage table) {
		this.table = table;
	}



	public BufferedImage getBlackcar() {
		return blackcar;
	}



	public void setBlackcar(BufferedImage blackcar) {
		this.blackcar = blackcar;
	}



	public BufferedImage getBlackhorse() {
		return blackhorse;
	}



	public void setBlackhorse(BufferedImage blackhorse) {
		this.blackhorse = blackhorse;
	}



	public BufferedImage getBlackelephant() {
		return blackelephant;
	}



	public void setBlackelephant(BufferedImage blackelephant) {
		this.blackelephant = blackelephant;
	}



	public BufferedImage getBlackgenera() {
		return blackgenera;
	}



	public void setBlackgenera(BufferedImage blackgenera) {
		this.blackgenera = blackgenera;
	}



	public BufferedImage getBlackofficia() {
		return blackofficia;
	}



	public void setBlackofficia(BufferedImage blackofficia) {
		this.blackofficia = blackofficia;
	}



	public BufferedImage getBlackcannon() {
		return blackcannon;
	}



	public void setBlackcannon(BufferedImage blackcannon) {
		this.blackcannon = blackcannon;
	}



	public BufferedImage getBlacksoldier() {
		return blacksoldier;
	}



	public void setBlacksoldier(BufferedImage blacksoldier) {
		this.blacksoldier = blacksoldier;
	}



	public BufferedImage getRedcar() {
		return redcar;
	}



	public void setRedcar(BufferedImage redcar) {
		this.redcar = redcar;
	}



	public BufferedImage getRedhorse() {
		return redhorse;
	}



	public void setRedhorse(BufferedImage redhorse) {
		this.redhorse = redhorse;
	}



	public BufferedImage getRedelephant() {
		return redelephant;
	}



	public void setRedelephant(BufferedImage redelephant) {
		this.redelephant = redelephant;
	}



	public BufferedImage getRedgenera() {
		return redgenera;
	}



	public void setRedgenera(BufferedImage redgenera) {
		this.redgenera = redgenera;
	}



	public BufferedImage getRedofficia() {
		return redofficia;
	}



	public void setRedofficia(BufferedImage redofficia) {
		this.redofficia = redofficia;
	}



	public BufferedImage getRedcannon() {
		return redcannon;
	}



	public void setRedcannon(BufferedImage redcannon) {
		this.redcannon = redcannon;
	}



	public BufferedImage getRedsoldier() {
		return redsoldier;
	}



	public void setRedsoldier(BufferedImage redsoldier) {
		this.redsoldier = redsoldier;
	}
	
	
}
