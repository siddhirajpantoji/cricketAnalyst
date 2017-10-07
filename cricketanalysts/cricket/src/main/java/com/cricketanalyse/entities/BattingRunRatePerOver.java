package com.cricketanalyse.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class BattingRunRatePerOver extends AuditParams  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull( message = "test ")
	@ManyToOne
	@JoinColumn( name = "player_id")
	private Player player;

	private Long identifier;

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	@NotNull
	@ManyToOne
	@JoinColumn( name = "team_id")
	private Team againstTeam;

	private Float rate1;
	private Float rate2;
	private Float rate3;
	private Float rate4;
	private Float rate5;
	private Float rate6;
	private Float rate7;
	private Float rate8;
	private Float rate9;
	private Float rate10;
	
	private Float rate11;
	private Float rate12;
	private Float rate13;
	private Float rate14;
	private Float rate15;
	private Float rate16;
	private Float rate17;
	private Float rate18;
	private Float rate19;
	private Float rate20;
	private Float rate21;
	private Float rate22;
	private Float rate23;
	private Float rate24;
	private Float rate25;
	private Float rate26;
	private Float rate27;
	private Float rate28;
	private Float rate29;
	private Float rate30;
	private Float rate31;
	private Float rate32;
	private Float rate33;
	private Float rate34;
	private Float rate35;
	private Float rate36;
	private Float rate37;
	private Float rate38;
	private Float rate39;
	private Float rate40;
	private Float rate41;
	private Float rate42;
	private Float rate43;
	private Float rate44;
	private Float rate45;
	private Float rate46;
	private Float rate47;
	private Float rate48;
	private Float rate49;
	private Float rate50;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getAgainstTeam() {
		return againstTeam;
	}

	public void setAgainstTeam(Team againstTeam) {
		this.againstTeam = againstTeam;
	}

	public Float getRate1() {
		return rate1;
	}

	public void setRate1(Float rate1) {
		this.rate1 = rate1;
	}

	public Float getRate2() {
		return rate2;
	}

	public void setRate2(Float rate2) {
		this.rate2 = rate2;
	}

	public Float getRate3() {
		return rate3;
	}

	public void setRate3(Float rate3) {
		this.rate3 = rate3;
	}

	public Float getRate4() {
		return rate4;
	}

	public void setRate4(Float rate4) {
		this.rate4 = rate4;
	}

	public Float getRate5() {
		return rate5;
	}

	public void setRate5(Float rate5) {
		this.rate5 = rate5;
	}

	public Float getRate6() {
		return rate6;
	}

	public void setRate6(Float rate6) {
		this.rate6 = rate6;
	}

	public Float getRate7() {
		return rate7;
	}

	public void setRate7(Float rate7) {
		this.rate7 = rate7;
	}

	public Float getRate8() {
		return rate8;
	}

	public void setRate8(Float rate8) {
		this.rate8 = rate8;
	}

	public Float getRate9() {
		return rate9;
	}

	public void setRate9(Float rate9) {
		this.rate9 = rate9;
	}

	public Float getRate10() {
		return rate10;
	}

	public void setRate10(Float rate10) {
		this.rate10 = rate10;
	}

	public Float getRate11() {
		return rate11;
	}

	public void setRate11(Float rate11) {
		this.rate11 = rate11;
	}

	public Float getRate12() {
		return rate12;
	}

	public void setRate12(Float rate12) {
		this.rate12 = rate12;
	}

	public Float getRate13() {
		return rate13;
	}

	public void setRate13(Float rate13) {
		this.rate13 = rate13;
	}

	public Float getRate14() {
		return rate14;
	}

	public void setRate14(Float rate14) {
		this.rate14 = rate14;
	}

	public Float getRate15() {
		return rate15;
	}

	public void setRate15(Float rate15) {
		this.rate15 = rate15;
	}

	public Float getRate16() {
		return rate16;
	}

	public void setRate16(Float rate16) {
		this.rate16 = rate16;
	}

	public Float getRate17() {
		return rate17;
	}

	public void setRate17(Float rate17) {
		this.rate17 = rate17;
	}

	public Float getRate18() {
		return rate18;
	}

	public void setRate18(Float rate18) {
		this.rate18 = rate18;
	}

	public Float getRate19() {
		return rate19;
	}

	public void setRate19(Float rate19) {
		this.rate19 = rate19;
	}

	public Float getRate20() {
		return rate20;
	}

	public void setRate20(Float rate20) {
		this.rate20 = rate20;
	}

	public Float getRate21() {
		return rate21;
	}

	public void setRate21(Float rate21) {
		this.rate21 = rate21;
	}

	public Float getRate22() {
		return rate22;
	}

	public void setRate22(Float rate22) {
		this.rate22 = rate22;
	}

	public Float getRate23() {
		return rate23;
	}

	public void setRate23(Float rate23) {
		this.rate23 = rate23;
	}

	public Float getRate24() {
		return rate24;
	}

	public void setRate24(Float rate24) {
		this.rate24 = rate24;
	}

	public Float getRate25() {
		return rate25;
	}

	public void setRate25(Float rate25) {
		this.rate25 = rate25;
	}

	public Float getRate26() {
		return rate26;
	}

	public void setRate26(Float rate26) {
		this.rate26 = rate26;
	}

	public Float getRate27() {
		return rate27;
	}

	public void setRate27(Float rate27) {
		this.rate27 = rate27;
	}

	public Float getRate28() {
		return rate28;
	}

	public void setRate28(Float rate28) {
		this.rate28 = rate28;
	}

	public Float getRate29() {
		return rate29;
	}

	public void setRate29(Float rate29) {
		this.rate29 = rate29;
	}

	public Float getRate30() {
		return rate30;
	}

	public void setRate30(Float rate30) {
		this.rate30 = rate30;
	}

	public Float getRate31() {
		return rate31;
	}

	public void setRate31(Float rate31) {
		this.rate31 = rate31;
	}

	public Float getRate32() {
		return rate32;
	}

	public void setRate32(Float rate32) {
		this.rate32 = rate32;
	}

	public Float getRate33() {
		return rate33;
	}

	public void setRate33(Float rate33) {
		this.rate33 = rate33;
	}

	public Float getRate34() {
		return rate34;
	}

	public void setRate34(Float rate34) {
		this.rate34 = rate34;
	}

	public Float getRate35() {
		return rate35;
	}

	public void setRate35(Float rate35) {
		this.rate35 = rate35;
	}

	public Float getRate36() {
		return rate36;
	}

	public void setRate36(Float rate36) {
		this.rate36 = rate36;
	}

	public Float getRate37() {
		return rate37;
	}

	public void setRate37(Float rate37) {
		this.rate37 = rate37;
	}

	public Float getRate38() {
		return rate38;
	}

	public void setRate38(Float rate38) {
		this.rate38 = rate38;
	}

	public Float getRate39() {
		return rate39;
	}

	public void setRate39(Float rate39) {
		this.rate39 = rate39;
	}

	public Float getRate40() {
		return rate40;
	}

	public void setRate40(Float rate40) {
		this.rate40 = rate40;
	}

	public Float getRate41() {
		return rate41;
	}

	public void setRate41(Float rate41) {
		this.rate41 = rate41;
	}

	public Float getRate42() {
		return rate42;
	}

	public void setRate42(Float rate42) {
		this.rate42 = rate42;
	}

	public Float getRate43() {
		return rate43;
	}

	public void setRate43(Float rate43) {
		this.rate43 = rate43;
	}

	public Float getRate44() {
		return rate44;
	}

	public void setRate44(Float rate44) {
		this.rate44 = rate44;
	}

	public Float getRate45() {
		return rate45;
	}

	public void setRate45(Float rate45) {
		this.rate45 = rate45;
	}

	public Float getRate46() {
		return rate46;
	}

	public void setRate46(Float rate46) {
		this.rate46 = rate46;
	}

	public Float getRate47() {
		return rate47;
	}

	public void setRate47(Float rate47) {
		this.rate47 = rate47;
	}

	public Float getRate48() {
		return rate48;
	}

	public void setRate48(Float rate48) {
		this.rate48 = rate48;
	}

	public Float getRate49() {
		return rate49;
	}

	public void setRate49(Float rate49) {
		this.rate49 = rate49;
	}

	public Float getRate50() {
		return rate50;
	}

	public void setRate50(Float rate50) {
		this.rate50 = rate50;
	}

	public BattingRunRatePerOver(Player player, Team againstTeam) {
		this.player = player;
		this.againstTeam = againstTeam;
	}
	
	public BattingRunRatePerOver() {
	}
}
