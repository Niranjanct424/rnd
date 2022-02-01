package com.jva.rnd.audio;

import java.io.Serializable;
import java.util.Arrays;

public class MotIvrAudioFile implements Serializable {
	private static final long serialVersionID = 1L;

	private String sentToMedallia;
	private byte[] data;

	public String getSentToMedallia() {
		return sentToMedallia;
	}

	public void setSentToMedallia(String sentToMedallia) {
		this.sentToMedallia = sentToMedallia;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MotIvrAudioFile [sentToMedallia=" + sentToMedallia + ", data=" + Arrays.toString(data) + "]";
	}
}
