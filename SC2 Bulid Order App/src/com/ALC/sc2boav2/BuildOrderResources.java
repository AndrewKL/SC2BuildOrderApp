package com.ALC.sc2boav2;

public class BuildOrderResources {
	private static final String eol = System.getProperty("line.separator");
	public final static BuildOrder terranbuild = new BuildOrder(
			"5 rax",
			"9 depot "+eol+"13 Barracks "+eol+"15 Orbital Command "+eol+" 15 4 Barracks",
			BuildOrder.terran,0);
	public final static BuildOrder zergbuild = new BuildOrder(
			"6 Pool",
			"6 pool"+eol+"7 overlord",
			BuildOrder.zerg,0);
	public final static BuildOrder protossbuild = new BuildOrder(
			"4 Gate",
			"9 pylon"+eol+"13 gate",
			BuildOrder.protoss,0);

}
