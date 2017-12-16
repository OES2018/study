package zh;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ChessPieces {
	//ÆåÅÌ
    private ImageIcon table;
	//ºÚ×Ó
	private ImageIcon blackcar,blackhorse,blackelephant,blackgenera,blackofficia,blackcannon,blacksoldier;
	//ºì×Ó
	private ImageIcon redcar,redhorse,redelephant,redgenera,redofficia,redcannon,redsoldier;
	
	public ChessPieces() throws IOException {
		super();
		this.table = new ImageIcon("image\\main.gif");
		this.blackcar =new ImageIcon("image\\ºÚ³µ.gif");
		this.blackhorse = new ImageIcon("image\\ºÚÂí.gif");
		this.blackelephant =  new ImageIcon("image\\ºÚÏó.gif");
		this.blackgenera = new ImageIcon("image\\ºÚ½«.gif");
		this.blackofficia =new ImageIcon("image\\ºÚÊ¿.gif");
		this.blackcannon = new ImageIcon("image\\ºÚÅÚ.gif");		
		this.blacksoldier = new ImageIcon("image\\ºÚ×ä.gif");
		this.redcar =new ImageIcon("image\\ºì³µ.gif");
		this.redhorse = new ImageIcon("image\\ºìÂí.gif");
		this.redelephant = new ImageIcon("image\\ºìÏó.gif");	
		this.redgenera = new ImageIcon("image\\ºì½«.gif");		
		this.redofficia =  new ImageIcon("image\\ºìÊ¿.gif");
		this.redcannon = new ImageIcon("image\\ºìÅÚ.gif");
		this.redsoldier =new ImageIcon("image\\ºì×ä.gif");
	}

	public ImageIcon getTable() {
		return table;
	}

	public void setTable(ImageIcon table) {
		this.table = table;
	}

	public ImageIcon getBlackcar() {
		return blackcar;
	}

	public void setBlackcar(ImageIcon blackcar) {
		this.blackcar = blackcar;
	}

	public ImageIcon getBlackhorse() {
		return blackhorse;
	}

	public void setBlackhorse(ImageIcon blackhorse) {
		this.blackhorse = blackhorse;
	}

	public ImageIcon getBlackelephant() {
		return blackelephant;
	}

	public void setBlackelephant(ImageIcon blackelephant) {
		this.blackelephant = blackelephant;
	}

	public ImageIcon getBlackgenera() {
		return blackgenera;
	}

	public void setBlackgenera(ImageIcon blackgenera) {
		this.blackgenera = blackgenera;
	}

	public ImageIcon getBlackofficia() {
		return blackofficia;
	}

	public void setBlackofficia(ImageIcon blackofficia) {
		this.blackofficia = blackofficia;
	}

	public ImageIcon getBlackcannon() {
		return blackcannon;
	}

	public void setBlackcannon(ImageIcon blackcannon) {
		this.blackcannon = blackcannon;
	}

	public ImageIcon getBlacksoldier() {
		return blacksoldier;
	}

	public void setBlacksoldier(ImageIcon blacksoldier) {
		this.blacksoldier = blacksoldier;
	}

	public ImageIcon getRedcar() {
		return redcar;
	}

	public void setRedcar(ImageIcon redcar) {
		this.redcar = redcar;
	}

	public ImageIcon getRedhorse() {
		return redhorse;
	}

	public void setRedhorse(ImageIcon redhorse) {
		this.redhorse = redhorse;
	}

	public ImageIcon getRedelephant() {
		return redelephant;
	}

	public void setRedelephant(ImageIcon redelephant) {
		this.redelephant = redelephant;
	}

	public ImageIcon getRedgenera() {
		return redgenera;
	}

	public void setRedgenera(ImageIcon redgenera) {
		this.redgenera = redgenera;
	}

	public ImageIcon getRedofficia() {
		return redofficia;
	}

	public void setRedofficia(ImageIcon redofficia) {
		this.redofficia = redofficia;
	}

	public ImageIcon getRedcannon() {
		return redcannon;
	}

	public void setRedcannon(ImageIcon redcannon) {
		this.redcannon = redcannon;
	}

	public ImageIcon getRedsoldier() {
		return redsoldier;
	}

	public void setRedsoldier(ImageIcon redsoldier) {
		this.redsoldier = redsoldier;
	}
	
	
}
