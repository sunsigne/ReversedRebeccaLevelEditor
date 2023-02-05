package com.sunsigne.reversedrebeccaleveleditor.world;

public interface Zoomable {

	////////// ZOOM ////////////

	public SIZE getZoom();

	public void setZoom(SIZE zoom);

	public default void zoomOut() {
		setZoom(getZoom().getPrevious());
	}
	
	public default void zoomIn() {
		setZoom(getZoom().getNext());
	}
		
	////////// SIZE ////////////

	static final int TILE = 8;
	
	public enum SIZE {
		XS(1 * TILE), S(2 * TILE), M(3 * TILE), L(4 * TILE), XL(5 * TILE), XXL(7 * TILE);

		private int size;

		SIZE(int size) {
			this.size = size;
		}

		public int getSize() {
			return size;
		}

		public SIZE getPrevious() {
			switch (size) {
			case 7 * TILE:
				return SIZE.XL;
			case 5 * TILE:
				return SIZE.L;
			case 4 * TILE:
				return SIZE.M;
			case 3 * TILE:
				return SIZE.S;
			case 2 * TILE:
				return SIZE.XS;
			}
			return SIZE.XS;
		}
		
		public SIZE getNext() {
			switch (size) {
			case 1 * TILE:
				return SIZE.S;
			case 2 * TILE:
				return SIZE.M;
			case 3 * TILE:
				return SIZE.L;
			case 4 * TILE:
				return SIZE.XL;
			case 5 * TILE:
				return SIZE.XXL;
			}
			return SIZE.XXL;
		}		
	}

}
