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

/**
 * Hole is a hole on jelly cell, it works like synapse on nerve cell
 * 
 * 以前叫突触，现在改名叫洞，更形象一点，每个光子传来就好象在果冻上砸出个洞。管它符不符合生物脑突触这个形象，张牙舞爪的神经元变成了千创百孔的果冻，先乱试一通再说。
 * 
 * @author Yong Zhu
 * @since 2.0.2
 */
public class Hole {
	public float x;// x,y,z 是 洞的中心坐标点，这个是脑内的绝对坐标
	public float y;
	public float z;
	public float mx; // mx,my,mz分别是光子砸出这个洞时的光子每单元移动方向在三个轴上的投影
	public float my;
	public float mz;
	public float size = 0;// 洞的大小，收到光子会变大1.1倍直到饱和，平时会沿指数曲线消失 

	public Hole(Photon p) {
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
		this.mx = p.mx;
		this.my = p.my;
		this.mz = p.mz; 
	}

	public float angleCompare(Hole p) {// 比较洞与光子之间的角度差值
		return Math.abs(p.mx - mx) + Math.abs(p.my - my) + Math.abs(p.mz - mz);
	}

	public float angleCompare(Photon p) {// 比较洞与光子之间的角度差值
		return Math.abs(p.mx - mx) + Math.abs(p.my - my) + Math.abs(p.mz - mz);
	}

	public boolean ifSameWay(Photon p) {// 如果光子运动方向与洞完全同向,实际上也就是说从同一个波源发出来的
		return Math.abs(p.mx - mx) < 0.0001 && Math.abs(p.my - my) < 0.0001 && Math.abs(p.mz - mz) < 0.0001;
	}

	public boolean ifSimilarWay(Photon p) {// 如果光子运动方向与洞近似相同
		return Math.abs(p.mx - mx) < 0.05 && Math.abs(p.my - my) < 0.05 && Math.abs(p.mz - mz) < 0.05;
	}

}
