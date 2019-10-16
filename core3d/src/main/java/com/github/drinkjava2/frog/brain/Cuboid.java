/*
 * Copyright 2018 the original author or authors. 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.github.drinkjava2.frog.brain;

import java.io.Serializable;

/**
 * Cuboid represents a rectangular prism zone in brain
 * 
 * @author Yong Zhu
 * @since 1.0
 */
public class Cuboid implements Serializable {
	private static final long serialVersionUID = 1L;

	public int x;// x,y,z是长方体的左下角坐标
	public int y;
	public int z;
	public int xe;// xe,ye,ze分别是长方体三边长
	public int ye;
	public int ze;

	public Cuboid() {
		// 空构造器不能省
	}

	public Cuboid(int x, int y, int z, int xe, int ye, int ze) {// 用x,y,z,r来构造
		this.x = x;
		this.y = y;
		this.z = z;
		this.xe = xe;
		this.ye = ye;
		this.ze = ze;
	}

	public Cuboid(Cuboid c) {// 用另一个Cube来构造
		this.x = c.x;
		this.y = c.y;
		this.z = c.z;
		this.xe = c.xe;
		this.ye = c.ye;
		this.ze = c.ze;
	}

	public static void copyXYZ(Cuboid from, Cuboid to) {
		to.x = from.x;
		to.y = from.y;
		to.z = from.z;
	}

	public static void copyXYZE(Cuboid from, Cuboid to) {
		to.x = from.x;
		to.y = from.y;
		to.z = from.z;
		to.xe = from.xe;
		to.xe = from.xe;
		to.xe = from.xe;
	}

}