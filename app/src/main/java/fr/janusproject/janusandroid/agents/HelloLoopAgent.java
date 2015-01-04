package fr.janusproject.janusandroid.agents;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import java.util.UUID;

import io.sarl.core.AgentKilled;
import io.sarl.core.AgentSpawned;
import io.sarl.core.AgentTask;
import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.core.Lifecycle;
import io.sarl.core.Logging;
import io.sarl.core.Schedules;
import io.sarl.lang.annotation.EarlyExit;
import io.sarl.lang.annotation.FiredEvent;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.annotation.ImportedCapacityFeature;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.AgentContext;
import io.sarl.lang.core.Percept;

/**
 * Created by Thomaspiotrowski on 1/4/15.
 */
@SuppressWarnings("all")
public class HelloLoopAgent extends Agent {
    protected int compt = 0;

    @Percept
    public void _handle_Initialize_0(final Initialize occurrence) {
        this.println("Je suis vivant");
        final Procedure1<Agent> _function = new Procedure1<Agent>() {
            public void apply(final Agent it) {
                HelloLoopAgent.this.println("Living...");
                HelloLoopAgent.this.compt++;
                if ((HelloLoopAgent.this.compt >= 5)) {
                    HelloLoopAgent.this.killMe();
                }
            }
        };
        this.every(5000, _function);
    }

    @Percept
    public void _handle_Destroy_1(final Destroy occurrence) {
        this.println("je suis mort");
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#debug(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#debug(java.lang.Object).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void debug(final Object message) {
        getSkill(io.sarl.core.Logging.class).debug(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#error(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#error(java.lang.Object).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void error(final Object message) {
        getSkill(io.sarl.core.Logging.class).error(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#error(java.lang.Object,java.lang.Throwable)}.
     *
     * @see io.sarl.core.Logging#error(java.lang.Object,java.lang.Throwable).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void error(final Object message, final Throwable exception) {
        getSkill(io.sarl.core.Logging.class).error(message, exception);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#getLogLevel()}.
     *
     * @see io.sarl.core.Logging#getLogLevel().
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected int getLogLevel() {
        return getSkill(io.sarl.core.Logging.class).getLogLevel();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#info(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#info(java.lang.Object).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void info(final Object message) {
        getSkill(io.sarl.core.Logging.class).info(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isDebugLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isDebugLogEnabled().
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected boolean isDebugLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isDebugLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isErrorLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isErrorLogEnabled().
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected boolean isErrorLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isErrorLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isInfoLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isInfoLogEnabled().
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected boolean isInfoLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isInfoLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isWarningLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isWarningLogEnabled().
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected boolean isWarningLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isWarningLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#println(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#println(java.lang.Object).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void println(final Object message) {
        getSkill(io.sarl.core.Logging.class).println(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#setLogLevel(int)}.
     *
     * @see io.sarl.core.Logging#setLogLevel(int).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void setLogLevel(final int level) {
        getSkill(io.sarl.core.Logging.class).setLogLevel(level);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#setLoggingName(java.lang.String)}.
     *
     * @see io.sarl.core.Logging#setLoggingName(java.lang.String).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void setLoggingName(final String message) {
        getSkill(io.sarl.core.Logging.class).setLoggingName(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#warning(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#warning(java.lang.Object).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void warning(final Object message) {
        getSkill(io.sarl.core.Logging.class).warning(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#warning(java.lang.Object,java.lang.Throwable)}.
     *
     * @see io.sarl.core.Logging#warning(java.lang.Object,java.lang.Throwable).
     */
    @Generated
    @ImportedCapacityFeature(Logging.class)
    protected void warning(final Object message, final Throwable exception) {
        getSkill(io.sarl.core.Logging.class).warning(message, exception);
    }

    /**
     * See the capacity {@link io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask)}.
     *
     * @see io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask).
     */
    @Generated
    @ImportedCapacityFeature(Schedules.class)
    protected boolean cancel(final AgentTask task) {
        return getSkill(io.sarl.core.Schedules.class).cancel(task);
    }

    /**
     * See the capacity {@link io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask,boolean)}.
     *
     * @see io.sarl.core.Schedules#cancel(io.sarl.core.AgentTask,boolean).
     */
    @Generated
    @ImportedCapacityFeature(Schedules.class)
    protected boolean cancel(final AgentTask task, final boolean mayInterruptIfRunning) {
        return getSkill(io.sarl.core.Schedules.class).cancel(task, mayInterruptIfRunning);
    }

    /**
     * See the capacity {@link io.sarl.core.Schedules#every(long,(io.sarl.lang.core.Agent)=>void)}.
     *
     * @see io.sarl.core.Schedules#every(long,(io.sarl.lang.core.Agent)=>void).
     */
    @Generated
    @ImportedCapacityFeature(Schedules.class)
    protected AgentTask every(final long period, final Procedure1<? super Agent> procedure) {
        return getSkill(io.sarl.core.Schedules.class).every(period, procedure);
    }

    /**
     * See the capacity {@link io.sarl.core.Schedules#every(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void)}.
     *
     * @see io.sarl.core.Schedules#every(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void).
     */
    @Generated
    @ImportedCapacityFeature(Schedules.class)
    protected AgentTask every(final AgentTask task, final long period, final Procedure1<? super Agent> procedure) {
        return getSkill(io.sarl.core.Schedules.class).every(task, period, procedure);
    }

    /**
     * See the capacity {@link io.sarl.core.Schedules#in(long,(io.sarl.lang.core.Agent)=>void)}.
     *
     * @see io.sarl.core.Schedules#in(long,(io.sarl.lang.core.Agent)=>void).
     */
    @Generated
    @ImportedCapacityFeature(Schedules.class)
    protected AgentTask in(final long delay, final Procedure1<? super Agent> procedure) {
        return getSkill(io.sarl.core.Schedules.class).in(delay, procedure);
    }

    /**
     * See the capacity {@link io.sarl.core.Schedules#in(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void)}.
     *
     * @see io.sarl.core.Schedules#in(io.sarl.core.AgentTask,long,(io.sarl.lang.core.Agent)=>void).
     */
    @Generated
    @ImportedCapacityFeature(Schedules.class)
    protected AgentTask in(final AgentTask task, final long delay, final Procedure1<? super Agent> procedure) {
        return getSkill(io.sarl.core.Schedules.class).in(task, delay, procedure);
    }

    /**
     * See the capacity {@link io.sarl.core.Schedules#task(java.lang.String)}.
     *
     * @see io.sarl.core.Schedules#task(java.lang.String).
     */
    @Generated
    @ImportedCapacityFeature(Schedules.class)
    protected AgentTask task(final String name) {
        return getSkill(io.sarl.core.Schedules.class).task(name);
    }

    /**
     * See the capacity {@link io.sarl.core.Lifecycle#killMe()}.
     *
     * @see io.sarl.core.Lifecycle#killMe().
     */
    @EarlyExit
    @FiredEvent({ AgentKilled.class, Destroy.class })
    @Generated
    @ImportedCapacityFeature(Lifecycle.class)
    protected void killMe() {
        getSkill(io.sarl.core.Lifecycle.class).killMe();
    }

    /**
     * See the capacity {@link io.sarl.core.Lifecycle#spawnInContext(java.lang.Class<? extends io.sarl.lang.core.Agent>,io.sarl.lang.core.AgentContext,java.lang.Object[])}.
     *
     * @see io.sarl.core.Lifecycle#spawnInContext(java.lang.Class<? extends io.sarl.lang.core.Agent>,io.sarl.lang.core.AgentContext,java.lang.Object[]).
     */
    @FiredEvent(AgentSpawned.class)
    @Generated
    @ImportedCapacityFeature(Lifecycle.class)
    protected UUID spawnInContext(final Class<? extends Agent> agentClass, final AgentContext context, final Object... params) {
        return getSkill(io.sarl.core.Lifecycle.class).spawnInContext(agentClass, context, params);
    }

    /**
     * See the capacity {@link io.sarl.core.Lifecycle#spawnInContextWithID(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.util.UUID,io.sarl.lang.core.AgentContext,java.lang.Object[])}.
     *
     * @see io.sarl.core.Lifecycle#spawnInContextWithID(java.lang.Class<? extends io.sarl.lang.core.Agent>,java.util.UUID,io.sarl.lang.core.AgentContext,java.lang.Object[]).
     */
    @FiredEvent(AgentSpawned.class)
    @Generated
    @ImportedCapacityFeature(Lifecycle.class)
    protected UUID spawnInContextWithID(final Class<? extends Agent> agentClass, final UUID agentID, final AgentContext context, final Object... params) {
        return getSkill(io.sarl.core.Lifecycle.class).spawnInContextWithID(agentClass, agentID, context, params);
    }

    /**
     * Construct an agent.
     * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
     */
    @Generated
    public HelloLoopAgent(final UUID parentID) {
        super(parentID, null);
    }

    /**
     * Construct an agent.
     * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
     * @param agentID - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
     */
    @Generated
    public HelloLoopAgent(final UUID parentID, final UUID agentID) {
        super(parentID, agentID);
    }
}

