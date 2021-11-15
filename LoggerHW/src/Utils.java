
public class Utils {
	public static void runLoggers(LoggerService[] loggers) {
		for (LoggerService logger : loggers) {
			logger.log();
		}

	}
}
