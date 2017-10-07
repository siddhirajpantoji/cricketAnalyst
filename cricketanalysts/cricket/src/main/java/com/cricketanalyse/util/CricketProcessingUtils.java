package com.cricketanalyse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricketanalyse.entities.BattingNoOfRunsScored;
import com.cricketanalyse.entities.BattingRunRatePerOver;
import com.cricketanalyse.entities.BattingRunsAtEndOfScored;
import com.cricketanalyse.repositories.BattingNoOfRunsScoredRepository;
import com.cricketanalyse.repositories.BattingRunRatePerOverRepository;
import com.cricketanalyse.repositories.BattingRunsAtEndOfScoredRepo;

@Service 
public class CricketProcessingUtils {

	@Autowired
	BattingNoOfRunsScoredRepository runsAtEndOfScoredRepo;

	@Autowired
	BattingRunRatePerOverRepository runRateRepository;
	
	@Autowired
	BattingRunsAtEndOfScoredRepo atEndOfScoredRepo;
	
	public BattingNoOfRunsScored calculateRunsForCurrrentOver(BattingRunsAtEndOfScored scoredRunsTillEnd) {
		BattingNoOfRunsScored  runsForCurrentOver = runsAtEndOfScoredRepo.findByIdentifier(scoredRunsTillEnd.getId());
		if( null == runsForCurrentOver )
		{
			runsForCurrentOver = new BattingNoOfRunsScored(scoredRunsTillEnd.getPlayer(), scoredRunsTillEnd.getAgainstTeam());
			runsForCurrentOver.setIdentifier(scoredRunsTillEnd.getId());
		}
		runsForCurrentOver.setOver1(scoredRunsTillEnd.getOver1());
		runsForCurrentOver.setOver2( this.isValidToAdd(scoredRunsTillEnd.getOver1(), scoredRunsTillEnd.getOver2()) ? (scoredRunsTillEnd.getOver2()- scoredRunsTillEnd.getOver1()) : null);
		runsForCurrentOver.setOver3( this.isValidToAdd(scoredRunsTillEnd.getOver2(), scoredRunsTillEnd.getOver3()) ? (scoredRunsTillEnd.getOver3()- scoredRunsTillEnd.getOver2()) : null);
		runsForCurrentOver.setOver4( this.isValidToAdd(scoredRunsTillEnd.getOver3(), scoredRunsTillEnd.getOver4()) ? (scoredRunsTillEnd.getOver4()- scoredRunsTillEnd.getOver3()) : null);
		runsForCurrentOver.setOver5( this.isValidToAdd(scoredRunsTillEnd.getOver4(), scoredRunsTillEnd.getOver5()) ? (scoredRunsTillEnd.getOver5()- scoredRunsTillEnd.getOver4()) : null);
		runsForCurrentOver.setOver6( this.isValidToAdd(scoredRunsTillEnd.getOver5(), scoredRunsTillEnd.getOver6()) ? (scoredRunsTillEnd.getOver6()- scoredRunsTillEnd.getOver5()) : null);
		runsForCurrentOver.setOver7( this.isValidToAdd(scoredRunsTillEnd.getOver6(), scoredRunsTillEnd.getOver7()) ? (scoredRunsTillEnd.getOver7()- scoredRunsTillEnd.getOver6()) : null);
		runsForCurrentOver.setOver8( this.isValidToAdd(scoredRunsTillEnd.getOver7(), scoredRunsTillEnd.getOver8()) ? (scoredRunsTillEnd.getOver8()- scoredRunsTillEnd.getOver7()) : null);
		runsForCurrentOver.setOver9( this.isValidToAdd(scoredRunsTillEnd.getOver8(), scoredRunsTillEnd.getOver9()) ? (scoredRunsTillEnd.getOver9()- scoredRunsTillEnd.getOver8()) : null);
		runsForCurrentOver.setOver10( this.isValidToAdd(scoredRunsTillEnd.getOver9(), scoredRunsTillEnd.getOver10()) ? (scoredRunsTillEnd.getOver10()- scoredRunsTillEnd.getOver9()) : null);
		runsForCurrentOver.setOver11( this.isValidToAdd(scoredRunsTillEnd.getOver10(), scoredRunsTillEnd.getOver11()) ? (scoredRunsTillEnd.getOver11()- scoredRunsTillEnd.getOver10()) : null);
		runsForCurrentOver.setOver12( this.isValidToAdd(scoredRunsTillEnd.getOver11(), scoredRunsTillEnd.getOver12()) ? (scoredRunsTillEnd.getOver12()- scoredRunsTillEnd.getOver11()) : null);
		runsForCurrentOver.setOver13( this.isValidToAdd(scoredRunsTillEnd.getOver12(), scoredRunsTillEnd.getOver13()) ? (scoredRunsTillEnd.getOver13()- scoredRunsTillEnd.getOver12()) : null);
		runsForCurrentOver.setOver14( this.isValidToAdd(scoredRunsTillEnd.getOver13(), scoredRunsTillEnd.getOver14()) ? (scoredRunsTillEnd.getOver14()- scoredRunsTillEnd.getOver13()) : null);
		runsForCurrentOver.setOver15( this.isValidToAdd(scoredRunsTillEnd.getOver14(), scoredRunsTillEnd.getOver15()) ? (scoredRunsTillEnd.getOver15()- scoredRunsTillEnd.getOver14()) : null);
		runsForCurrentOver.setOver16( this.isValidToAdd(scoredRunsTillEnd.getOver15(), scoredRunsTillEnd.getOver16()) ? (scoredRunsTillEnd.getOver16()- scoredRunsTillEnd.getOver15()) : null);
		runsForCurrentOver.setOver17( this.isValidToAdd(scoredRunsTillEnd.getOver16(), scoredRunsTillEnd.getOver17()) ? (scoredRunsTillEnd.getOver17()- scoredRunsTillEnd.getOver16()) : null);
		runsForCurrentOver.setOver18( this.isValidToAdd(scoredRunsTillEnd.getOver17(), scoredRunsTillEnd.getOver18()) ? (scoredRunsTillEnd.getOver18()- scoredRunsTillEnd.getOver17()) : null);
		runsForCurrentOver.setOver19( this.isValidToAdd(scoredRunsTillEnd.getOver18(), scoredRunsTillEnd.getOver19()) ? (scoredRunsTillEnd.getOver19()- scoredRunsTillEnd.getOver18()) : null);
		runsForCurrentOver.setOver20( this.isValidToAdd(scoredRunsTillEnd.getOver19(), scoredRunsTillEnd.getOver20()) ? (scoredRunsTillEnd.getOver20()- scoredRunsTillEnd.getOver19()) : null);
		runsForCurrentOver.setOver21( this.isValidToAdd(scoredRunsTillEnd.getOver20(), scoredRunsTillEnd.getOver21()) ? (scoredRunsTillEnd.getOver21()- scoredRunsTillEnd.getOver20()) : null);
		runsForCurrentOver.setOver22( this.isValidToAdd(scoredRunsTillEnd.getOver21(), scoredRunsTillEnd.getOver22()) ? (scoredRunsTillEnd.getOver22()- scoredRunsTillEnd.getOver21()) : null);
		runsForCurrentOver.setOver23( this.isValidToAdd(scoredRunsTillEnd.getOver22(), scoredRunsTillEnd.getOver23()) ? (scoredRunsTillEnd.getOver23()- scoredRunsTillEnd.getOver22()) : null);
		runsForCurrentOver.setOver24( this.isValidToAdd(scoredRunsTillEnd.getOver23(), scoredRunsTillEnd.getOver24()) ? (scoredRunsTillEnd.getOver24()- scoredRunsTillEnd.getOver23()) : null);
		runsForCurrentOver.setOver25( this.isValidToAdd(scoredRunsTillEnd.getOver24(), scoredRunsTillEnd.getOver25()) ? (scoredRunsTillEnd.getOver25()- scoredRunsTillEnd.getOver24()) : null);
		runsForCurrentOver.setOver26( this.isValidToAdd(scoredRunsTillEnd.getOver25(), scoredRunsTillEnd.getOver26()) ? (scoredRunsTillEnd.getOver26()- scoredRunsTillEnd.getOver25()) : null);
		runsForCurrentOver.setOver27( this.isValidToAdd(scoredRunsTillEnd.getOver26(), scoredRunsTillEnd.getOver27()) ? (scoredRunsTillEnd.getOver27()- scoredRunsTillEnd.getOver26()) : null);
		runsForCurrentOver.setOver28( this.isValidToAdd(scoredRunsTillEnd.getOver27(), scoredRunsTillEnd.getOver28()) ? (scoredRunsTillEnd.getOver28()- scoredRunsTillEnd.getOver27()) : null);
		runsForCurrentOver.setOver29( this.isValidToAdd(scoredRunsTillEnd.getOver28(), scoredRunsTillEnd.getOver29()) ? (scoredRunsTillEnd.getOver29()- scoredRunsTillEnd.getOver28()) : null);
		runsForCurrentOver.setOver30( this.isValidToAdd(scoredRunsTillEnd.getOver29(), scoredRunsTillEnd.getOver30()) ? (scoredRunsTillEnd.getOver30()- scoredRunsTillEnd.getOver29()) : null);
		runsForCurrentOver.setOver31( this.isValidToAdd(scoredRunsTillEnd.getOver30(), scoredRunsTillEnd.getOver31()) ? (scoredRunsTillEnd.getOver31()- scoredRunsTillEnd.getOver30()) : null);
		runsForCurrentOver.setOver32( this.isValidToAdd(scoredRunsTillEnd.getOver31(), scoredRunsTillEnd.getOver32()) ? (scoredRunsTillEnd.getOver32()- scoredRunsTillEnd.getOver31()) : null);
		runsForCurrentOver.setOver33( this.isValidToAdd(scoredRunsTillEnd.getOver32(), scoredRunsTillEnd.getOver33()) ? (scoredRunsTillEnd.getOver33()- scoredRunsTillEnd.getOver32()) : null);
		runsForCurrentOver.setOver34( this.isValidToAdd(scoredRunsTillEnd.getOver33(), scoredRunsTillEnd.getOver34()) ? (scoredRunsTillEnd.getOver34()- scoredRunsTillEnd.getOver33()) : null);
		runsForCurrentOver.setOver35( this.isValidToAdd(scoredRunsTillEnd.getOver34(), scoredRunsTillEnd.getOver35()) ? (scoredRunsTillEnd.getOver35()- scoredRunsTillEnd.getOver34()) : null);
		runsForCurrentOver.setOver36( this.isValidToAdd(scoredRunsTillEnd.getOver35(), scoredRunsTillEnd.getOver36()) ? (scoredRunsTillEnd.getOver36()- scoredRunsTillEnd.getOver35()) : null);
		runsForCurrentOver.setOver37( this.isValidToAdd(scoredRunsTillEnd.getOver36(), scoredRunsTillEnd.getOver37()) ? (scoredRunsTillEnd.getOver37()- scoredRunsTillEnd.getOver36()) : null);
		runsForCurrentOver.setOver38( this.isValidToAdd(scoredRunsTillEnd.getOver37(), scoredRunsTillEnd.getOver38()) ? (scoredRunsTillEnd.getOver38()- scoredRunsTillEnd.getOver37()) : null);
		runsForCurrentOver.setOver39( this.isValidToAdd(scoredRunsTillEnd.getOver38(), scoredRunsTillEnd.getOver39()) ? (scoredRunsTillEnd.getOver39()- scoredRunsTillEnd.getOver38()) : null);
		runsForCurrentOver.setOver40( this.isValidToAdd(scoredRunsTillEnd.getOver39(), scoredRunsTillEnd.getOver40()) ? (scoredRunsTillEnd.getOver40()- scoredRunsTillEnd.getOver29()) : null);
		runsForCurrentOver.setOver41( this.isValidToAdd(scoredRunsTillEnd.getOver40(), scoredRunsTillEnd.getOver41()) ? (scoredRunsTillEnd.getOver41()- scoredRunsTillEnd.getOver40()) : null);
		runsForCurrentOver.setOver42( this.isValidToAdd(scoredRunsTillEnd.getOver41(), scoredRunsTillEnd.getOver42()) ? (scoredRunsTillEnd.getOver42()- scoredRunsTillEnd.getOver41()) : null);
		runsForCurrentOver.setOver43( this.isValidToAdd(scoredRunsTillEnd.getOver42(), scoredRunsTillEnd.getOver43()) ? (scoredRunsTillEnd.getOver43()- scoredRunsTillEnd.getOver42()) : null);
		runsForCurrentOver.setOver44( this.isValidToAdd(scoredRunsTillEnd.getOver43(), scoredRunsTillEnd.getOver44()) ? (scoredRunsTillEnd.getOver44()- scoredRunsTillEnd.getOver43()) : null);
		runsForCurrentOver.setOver45( this.isValidToAdd(scoredRunsTillEnd.getOver44(), scoredRunsTillEnd.getOver45()) ? (scoredRunsTillEnd.getOver45()- scoredRunsTillEnd.getOver44()) : null);
		runsForCurrentOver.setOver46( this.isValidToAdd(scoredRunsTillEnd.getOver45(), scoredRunsTillEnd.getOver46()) ? (scoredRunsTillEnd.getOver46()- scoredRunsTillEnd.getOver45()) : null);
		runsForCurrentOver.setOver47( this.isValidToAdd(scoredRunsTillEnd.getOver46(), scoredRunsTillEnd.getOver47()) ? (scoredRunsTillEnd.getOver47()- scoredRunsTillEnd.getOver46()) : null);
		runsForCurrentOver.setOver48( this.isValidToAdd(scoredRunsTillEnd.getOver47(), scoredRunsTillEnd.getOver48()) ? (scoredRunsTillEnd.getOver48()- scoredRunsTillEnd.getOver47()) : null);
		runsForCurrentOver.setOver49( this.isValidToAdd(scoredRunsTillEnd.getOver48(), scoredRunsTillEnd.getOver49()) ? (scoredRunsTillEnd.getOver49()- scoredRunsTillEnd.getOver48()) : null);
		runsForCurrentOver.setOver50( this.isValidToAdd(scoredRunsTillEnd.getOver49(), scoredRunsTillEnd.getOver50()) ? (scoredRunsTillEnd.getOver50()- scoredRunsTillEnd.getOver49()) : null);
		runsAtEndOfScoredRepo.save(runsForCurrentOver);		
		return runsForCurrentOver;
	}

	public Boolean isValidToAdd( Integer value1, Integer value2)
	{
		if( null != value1 && null != value2 )
			return true;
		else
			return false;
	}

	public Float calculateSingleRate( Integer runs, Integer overno)
	{
		if( null == runs )
			return null;

		return (((float)runs)/((float)overno));
	}

	public BattingRunRatePerOver calculateRunRate(BattingRunsAtEndOfScored scoredRunsTillEnd) {
		BattingRunRatePerOver battingRunRatePerOver = null;
		battingRunRatePerOver = runRateRepository.findByIdentifier(scoredRunsTillEnd.getId());
		if( null == battingRunRatePerOver )
		{
			battingRunRatePerOver = new BattingRunRatePerOver(scoredRunsTillEnd.getPlayer(), scoredRunsTillEnd.getAgainstTeam());
			battingRunRatePerOver.setIdentifier(scoredRunsTillEnd.getId());
		}
		battingRunRatePerOver.setRate1(calculateSingleRate(scoredRunsTillEnd.getOver1(), 1));
		battingRunRatePerOver.setRate2(calculateSingleRate(scoredRunsTillEnd.getOver2(), 2));
		battingRunRatePerOver.setRate3(calculateSingleRate(scoredRunsTillEnd.getOver3(), 3));
		battingRunRatePerOver.setRate4(calculateSingleRate(scoredRunsTillEnd.getOver4(), 4));
		battingRunRatePerOver.setRate5(calculateSingleRate(scoredRunsTillEnd.getOver5(), 5));
		battingRunRatePerOver.setRate6(calculateSingleRate(scoredRunsTillEnd.getOver6(), 6));
		battingRunRatePerOver.setRate7(calculateSingleRate(scoredRunsTillEnd.getOver7(), 7));
		battingRunRatePerOver.setRate8(calculateSingleRate(scoredRunsTillEnd.getOver8(), 8));
		battingRunRatePerOver.setRate9(calculateSingleRate(scoredRunsTillEnd.getOver9(), 9));
		battingRunRatePerOver.setRate10(calculateSingleRate(scoredRunsTillEnd.getOver10(), 10));
		battingRunRatePerOver.setRate11(calculateSingleRate(scoredRunsTillEnd.getOver11(), 11));
		battingRunRatePerOver.setRate12(calculateSingleRate(scoredRunsTillEnd.getOver12(), 12));
		battingRunRatePerOver.setRate13(calculateSingleRate(scoredRunsTillEnd.getOver13(), 13));
		battingRunRatePerOver.setRate14(calculateSingleRate(scoredRunsTillEnd.getOver14(), 14));
		battingRunRatePerOver.setRate15(calculateSingleRate(scoredRunsTillEnd.getOver15(), 15));
		battingRunRatePerOver.setRate16(calculateSingleRate(scoredRunsTillEnd.getOver16(), 16));
		battingRunRatePerOver.setRate17(calculateSingleRate(scoredRunsTillEnd.getOver17(), 17));
		battingRunRatePerOver.setRate18(calculateSingleRate(scoredRunsTillEnd.getOver18(), 18));
		battingRunRatePerOver.setRate19(calculateSingleRate(scoredRunsTillEnd.getOver19(), 19));
		battingRunRatePerOver.setRate20(calculateSingleRate(scoredRunsTillEnd.getOver20(), 20));
		battingRunRatePerOver.setRate21(calculateSingleRate(scoredRunsTillEnd.getOver21(), 21));
		battingRunRatePerOver.setRate22(calculateSingleRate(scoredRunsTillEnd.getOver22(), 22));
		battingRunRatePerOver.setRate23(calculateSingleRate(scoredRunsTillEnd.getOver23(), 23));
		battingRunRatePerOver.setRate24(calculateSingleRate(scoredRunsTillEnd.getOver24(), 24));
		battingRunRatePerOver.setRate25(calculateSingleRate(scoredRunsTillEnd.getOver25(), 25));
		battingRunRatePerOver.setRate26(calculateSingleRate(scoredRunsTillEnd.getOver26(), 26));
		battingRunRatePerOver.setRate27(calculateSingleRate(scoredRunsTillEnd.getOver27(), 27));
		battingRunRatePerOver.setRate28(calculateSingleRate(scoredRunsTillEnd.getOver28(), 28));
		battingRunRatePerOver.setRate29(calculateSingleRate(scoredRunsTillEnd.getOver29(), 29));
		battingRunRatePerOver.setRate30(calculateSingleRate(scoredRunsTillEnd.getOver30(), 30));
		battingRunRatePerOver.setRate31(calculateSingleRate(scoredRunsTillEnd.getOver31(), 31));
		battingRunRatePerOver.setRate32(calculateSingleRate(scoredRunsTillEnd.getOver32(), 32));
		battingRunRatePerOver.setRate33(calculateSingleRate(scoredRunsTillEnd.getOver33(), 33));
		battingRunRatePerOver.setRate34(calculateSingleRate(scoredRunsTillEnd.getOver34(), 34));
		battingRunRatePerOver.setRate35(calculateSingleRate(scoredRunsTillEnd.getOver35(), 35));
		battingRunRatePerOver.setRate36(calculateSingleRate(scoredRunsTillEnd.getOver36(), 36));
		battingRunRatePerOver.setRate37(calculateSingleRate(scoredRunsTillEnd.getOver37(), 37));
		battingRunRatePerOver.setRate38(calculateSingleRate(scoredRunsTillEnd.getOver38(), 38));
		battingRunRatePerOver.setRate39(calculateSingleRate(scoredRunsTillEnd.getOver39(), 39));
		battingRunRatePerOver.setRate40(calculateSingleRate(scoredRunsTillEnd.getOver40(), 40));
		battingRunRatePerOver.setRate41(calculateSingleRate(scoredRunsTillEnd.getOver41(), 41));
		battingRunRatePerOver.setRate42(calculateSingleRate(scoredRunsTillEnd.getOver42(), 42));
		battingRunRatePerOver.setRate43(calculateSingleRate(scoredRunsTillEnd.getOver43(), 43));
		battingRunRatePerOver.setRate44(calculateSingleRate(scoredRunsTillEnd.getOver44(), 44));
		battingRunRatePerOver.setRate45(calculateSingleRate(scoredRunsTillEnd.getOver45(), 45));
		battingRunRatePerOver.setRate46(calculateSingleRate(scoredRunsTillEnd.getOver46(), 46));
		battingRunRatePerOver.setRate47(calculateSingleRate(scoredRunsTillEnd.getOver47(), 47));
		battingRunRatePerOver.setRate48(calculateSingleRate(scoredRunsTillEnd.getOver48(), 48));
		battingRunRatePerOver.setRate49(calculateSingleRate(scoredRunsTillEnd.getOver49(), 49));
		battingRunRatePerOver.setRate50(calculateSingleRate(scoredRunsTillEnd.getOver50(), 50));
		battingRunRatePerOver = runRateRepository.save(battingRunRatePerOver);
		return battingRunRatePerOver;
	}
	
	public BattingRunsAtEndOfScored calculateAtEndOfForCurrentOver(BattingNoOfRunsScored runsSored) {
		
		BattingRunsAtEndOfScored  runsAtEndOfOver = atEndOfScoredRepo.findByIdentifier(runsSored.getId());
		if( null == runsAtEndOfOver )
		{
			runsAtEndOfOver = new BattingRunsAtEndOfScored(runsSored.getPlayer(), runsSored.getAgainstTeam());
			runsAtEndOfOver.setIdentifier(runsSored.getId());
		}
		runsAtEndOfOver.setOver1( runsAtEndOfOver.getOver1() );
		runsAtEndOfOver.setOver2( getTotalOfOverRuns( runsAtEndOfOver.getOver1(), runsSored.getOver2() ));
		runsAtEndOfOver.setOver3( getTotalOfOverRuns( runsAtEndOfOver.getOver2(), runsSored.getOver3() ));
		runsAtEndOfOver.setOver4( getTotalOfOverRuns( runsAtEndOfOver.getOver3(), runsSored.getOver4() ));
		runsAtEndOfOver.setOver5( getTotalOfOverRuns( runsAtEndOfOver.getOver4(), runsSored.getOver5() ));
		runsAtEndOfOver.setOver6( getTotalOfOverRuns( runsAtEndOfOver.getOver5(), runsSored.getOver6() ));
		runsAtEndOfOver.setOver7( getTotalOfOverRuns( runsAtEndOfOver.getOver6(), runsSored.getOver7() ));
		runsAtEndOfOver.setOver8( getTotalOfOverRuns( runsAtEndOfOver.getOver7(), runsSored.getOver8() ));
		runsAtEndOfOver.setOver9( getTotalOfOverRuns( runsAtEndOfOver.getOver8(), runsSored.getOver9() ));
		runsAtEndOfOver.setOver10( getTotalOfOverRuns( runsAtEndOfOver.getOver9(), runsSored.getOver10() ));
		runsAtEndOfOver.setOver11( getTotalOfOverRuns( runsAtEndOfOver.getOver10(), runsSored.getOver11() ));
		runsAtEndOfOver.setOver12( getTotalOfOverRuns( runsAtEndOfOver.getOver11(), runsSored.getOver12() ));
		runsAtEndOfOver.setOver13( getTotalOfOverRuns( runsAtEndOfOver.getOver12(), runsSored.getOver13() ));
		runsAtEndOfOver.setOver14( getTotalOfOverRuns( runsAtEndOfOver.getOver13(), runsSored.getOver14() ));
		runsAtEndOfOver.setOver15( getTotalOfOverRuns( runsAtEndOfOver.getOver14(), runsSored.getOver15() ));
		runsAtEndOfOver.setOver16( getTotalOfOverRuns( runsAtEndOfOver.getOver15(), runsSored.getOver16() ));
		runsAtEndOfOver.setOver17( getTotalOfOverRuns( runsAtEndOfOver.getOver16(), runsSored.getOver17() ));
		runsAtEndOfOver.setOver18( getTotalOfOverRuns( runsAtEndOfOver.getOver17(), runsSored.getOver18() ));
		runsAtEndOfOver.setOver19( getTotalOfOverRuns( runsAtEndOfOver.getOver18(), runsSored.getOver19() ));
		runsAtEndOfOver.setOver20( getTotalOfOverRuns( runsAtEndOfOver.getOver19(), runsSored.getOver20() ));
		

		runsAtEndOfOver.setOver21( getTotalOfOverRuns( runsAtEndOfOver.getOver20(), runsSored.getOver21() ));
		runsAtEndOfOver.setOver22( getTotalOfOverRuns( runsAtEndOfOver.getOver21(), runsSored.getOver22() ));
		runsAtEndOfOver.setOver23( getTotalOfOverRuns( runsAtEndOfOver.getOver22(), runsSored.getOver23() ));
		runsAtEndOfOver.setOver24( getTotalOfOverRuns( runsAtEndOfOver.getOver23(), runsSored.getOver24() ));
		runsAtEndOfOver.setOver25( getTotalOfOverRuns( runsAtEndOfOver.getOver24(), runsSored.getOver25() ));
		runsAtEndOfOver.setOver26( getTotalOfOverRuns( runsAtEndOfOver.getOver25(), runsSored.getOver26() ));
		runsAtEndOfOver.setOver27( getTotalOfOverRuns( runsAtEndOfOver.getOver26(), runsSored.getOver27() ));
		runsAtEndOfOver.setOver28( getTotalOfOverRuns( runsAtEndOfOver.getOver27(), runsSored.getOver28() ));
		runsAtEndOfOver.setOver29( getTotalOfOverRuns( runsAtEndOfOver.getOver28(), runsSored.getOver29() ));
		runsAtEndOfOver.setOver30( getTotalOfOverRuns( runsAtEndOfOver.getOver29(), runsSored.getOver30() ));
		

		runsAtEndOfOver.setOver31( getTotalOfOverRuns( runsAtEndOfOver.getOver30(), runsSored.getOver31() ));
		runsAtEndOfOver.setOver32( getTotalOfOverRuns( runsAtEndOfOver.getOver31(), runsSored.getOver32() ));
		runsAtEndOfOver.setOver33( getTotalOfOverRuns( runsAtEndOfOver.getOver32(), runsSored.getOver33() ));
		runsAtEndOfOver.setOver34( getTotalOfOverRuns( runsAtEndOfOver.getOver33(), runsSored.getOver34() ));
		runsAtEndOfOver.setOver35( getTotalOfOverRuns( runsAtEndOfOver.getOver34(), runsSored.getOver35() ));
		runsAtEndOfOver.setOver36( getTotalOfOverRuns( runsAtEndOfOver.getOver35(), runsSored.getOver36() ));
		runsAtEndOfOver.setOver37( getTotalOfOverRuns( runsAtEndOfOver.getOver36(), runsSored.getOver37() ));
		runsAtEndOfOver.setOver38( getTotalOfOverRuns( runsAtEndOfOver.getOver37(), runsSored.getOver38() ));
		runsAtEndOfOver.setOver39( getTotalOfOverRuns( runsAtEndOfOver.getOver38(), runsSored.getOver39() ));
		runsAtEndOfOver.setOver40( getTotalOfOverRuns( runsAtEndOfOver.getOver39(), runsSored.getOver40() ));
		runsAtEndOfOver.setOver41( getTotalOfOverRuns( runsAtEndOfOver.getOver40(), runsSored.getOver41() ));
		runsAtEndOfOver.setOver42( getTotalOfOverRuns( runsAtEndOfOver.getOver41(), runsSored.getOver42() ));
		runsAtEndOfOver.setOver43( getTotalOfOverRuns( runsAtEndOfOver.getOver42(), runsSored.getOver43() ));
		runsAtEndOfOver.setOver44( getTotalOfOverRuns( runsAtEndOfOver.getOver43(), runsSored.getOver44() ));
		runsAtEndOfOver.setOver45( getTotalOfOverRuns( runsAtEndOfOver.getOver44(), runsSored.getOver45() ));
		runsAtEndOfOver.setOver46( getTotalOfOverRuns( runsAtEndOfOver.getOver45(), runsSored.getOver46() ));
		runsAtEndOfOver.setOver47( getTotalOfOverRuns( runsAtEndOfOver.getOver46(), runsSored.getOver47() ));
		runsAtEndOfOver.setOver48( getTotalOfOverRuns( runsAtEndOfOver.getOver47(), runsSored.getOver48() ));
		runsAtEndOfOver.setOver49( getTotalOfOverRuns( runsAtEndOfOver.getOver48(), runsSored.getOver49() ));
		runsAtEndOfOver.setOver50( getTotalOfOverRuns( runsAtEndOfOver.getOver49(), runsSored.getOver50() ));
		runsAtEndOfOver= atEndOfScoredRepo.save(runsAtEndOfOver);
		return runsAtEndOfOver;
	}

	private Integer getTotalOfOverRuns(Integer over1, Integer over2)
	{
		// Identify if this over is first over  
		// If the prev is null then this is the first over . If the last is null then this is the last over		
		if( null == over1 && null == over2 )
			return null;
		// Start Condition 
		if( null == over1 && null != over2 )
			return over2;
		if( null == over2 && null != over1 )
			return null;
		
		return over1+over2;
	}
}
