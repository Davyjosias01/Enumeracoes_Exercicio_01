package entities.enums;

public enum WorkerLevel {
	JUNIOR(1), MID_LEVEL(2), SENIOR(3);

	public final int workerLevel;

	WorkerLevel(Integer workerLevel) {
		this.workerLevel = workerLevel;
	}

	public int getWorkerLevel() {
		return workerLevel;
	}

}
