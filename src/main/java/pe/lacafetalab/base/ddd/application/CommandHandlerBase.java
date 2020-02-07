package pe.lacafetalab.base.ddd.application;

public interface CommandHandlerBase<T extends CommandBase> {
	
	public void execute(T command);
	
}
