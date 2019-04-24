package com.zhouyun.training.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 小明过桥
 * 
 * 现在小明一家过一座桥，过桥时候是黑夜，所以必须有灯。
 * 现在小明过桥要１秒，小明的弟弟要３秒，小明的爸爸要６秒，小明的妈妈要８秒，小明的爷爷要１２秒。
 * 每次此桥最多可过两人，而过桥的速度依过桥最慢者而定，而且灯在点燃后３０秒就会熄灭。
 * 问小明一家如何过桥？
 *
 * @author 周云
 * @since  2016年9月29日
 */
public class Bridge {
	
	// 场景
	private Map<String, Integer> scene = new HashMap<String, Integer>();
	// 时限
	private int limit = 0;
	
	public Bridge(Map<String, Integer> scene, int limit) {
		this.scene = scene;
		this.limit = limit;
	}
	
	public boolean crossBridge() {
		
		// 总计用时
		int count = 0;
		
		// 过桥人员及动作：必须有序
		List<String> crossedKey = new ArrayList<String>();
		
		// 已过桥表
		Map<String, Integer> crossed = new HashMap<String, Integer>();
		// 未过桥表
		Map<String, Integer> notcrossed = new HashMap<String, Integer>();
		notcrossed.putAll(scene);
		
		Random random = new Random();
		// 有人未过桥，执行过桥动作
		while (notcrossed.size() >= 2) {
			// 未过桥者姓名
			Set<String> notcrossedKeys = notcrossed.keySet();
			Object[] notcrossedKeysArray = notcrossedKeys.toArray();
			// 从未过桥的人中选出两个过桥的
			int first = random.nextInt(notcrossed.size());
			int second;
			do {
				second = random.nextInt(notcrossed.size());
			} while (first == second);
			
			// 本次过桥的两个人
			String firstKey = (String) notcrossedKeysArray[first];
			String secondKey = (String) notcrossedKeysArray[second];
			
			// 将已过桥的加入到已过桥人员表中
			crossed.put(firstKey, scene.get(firstKey));
			crossed.put(secondKey, scene.get(secondKey));
			crossedKey.add(firstKey + "（过）");
			crossedKey.add(secondKey + "（过）");
			
			// 将已过桥的从未过桥人员表中删除
			notcrossed.remove(firstKey);
			notcrossed.remove(secondKey);
			
			// 计算时间
			int time = scene.get(firstKey) > scene.get(secondKey) ? scene.get(firstKey) : scene.get(secondKey);
			count = count + time;
			
			// 如果还有人未过桥，则需要从已过桥表中挑出一个回去
			if (notcrossed.size() > 0) {
				// 已过桥者姓名
				Set<String> crossedkeys = crossed.keySet();
				Object[] crossedKeysArray = crossedkeys.toArray();
				
				// 从已过桥的人中挑出一个回去
				int back = random.nextInt(crossed.size());
				
				// 被挑出回去者
				String backKey = (String) crossedKeysArray[back];
				
				// 将回去者从已过桥表删除，并加入未过桥表
				crossed.remove(backKey);
				crossedKey.add(backKey + "（回）");
				notcrossed.put(backKey, scene.get(backKey));
				
				// 计算时间
				count += scene.get(backKey);
			}
			
		}
		
		// 过桥完毕后，打印过桥动作
		StringBuffer output = new StringBuffer();
		output.append("总计用时：" + count + ",顺序为：");
		for (String key : crossedKey) {
			output.append(key + "、");
		}
		output.append("\n");
		System.out.println(output.toString());
		
		// 过桥完毕后，判断是否超时
		if (count > limit) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("小明", 1);
		map.put("小明的弟弟", 3);
		map.put("小明的爸爸", 6);
		map.put("小明的妈妈", 8);
		map.put("小明的爷爷", 12);
		
		Bridge bridge = new Bridge(map, 30);
		
		boolean isCrossed = false;
		while (!isCrossed) {
			isCrossed = bridge.crossBridge();
		}
	}
	
}
