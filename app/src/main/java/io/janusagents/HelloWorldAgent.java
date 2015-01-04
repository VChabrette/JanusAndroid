package io.janusagents;

import java.util.UUID;

import io.sarl.core.Destroy;
import io.sarl.core.Initialize;
import io.sarl.lang.annotation.Generated;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.Percept;

@SuppressWarnings("all")
public class HelloWorldAgent extends Agent {
    /**
     * Construct an agent.
     *
     * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
     */
    @Generated
    public HelloWorldAgent(final UUID parentID) {
        super(parentID, null);
    }

    /**
     * Construct an agent.
     *
     * @param parentID - identifier of the parent. It is the identifier of the parent agent and the enclosing contect, at the same time.
     * @param agentID  - identifier of the agent. If <code>null</code> the agent identifier will be computed randomly.
     */
    @Generated
    public HelloWorldAgent(final UUID parentID, final UUID agentID) {
        super(parentID, agentID);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#debug(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#debug(java.lang.Object).
     */
    @Generated
    protected void debug(final Object message) {
        getSkill(io.sarl.core.Logging.class).debug(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#error(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#error(java.lang.Object).
     */
    @Generated
    protected void error(final Object message) {
        getSkill(io.sarl.core.Logging.class).error(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#error(java.lang.Object, java.lang.Throwable)}.
     *
     * @see io.sarl.core.Logging#error(java.lang.Object, java.lang.Throwable).
     */
    @Generated
    protected void error(final Object message, final Throwable exception) {
        getSkill(io.sarl.core.Logging.class).error(message, exception);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#getLogLevel()}.
     *
     * @see io.sarl.core.Logging#getLogLevel().
     */
    @Generated
    protected int getLogLevel() {
        return getSkill(io.sarl.core.Logging.class).getLogLevel();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#info(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#info(java.lang.Object).
     */
    @Generated
    protected void info(final Object message) {
        getSkill(io.sarl.core.Logging.class).info(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isDebugLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isDebugLogEnabled().
     */
    @Generated
    protected boolean isDebugLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isDebugLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isErrorLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isErrorLogEnabled().
     */
    @Generated
    protected boolean isErrorLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isErrorLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isInfoLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isInfoLogEnabled().
     */
    @Generated
    protected boolean isInfoLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isInfoLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#isWarningLogEnabled()}.
     *
     * @see io.sarl.core.Logging#isWarningLogEnabled().
     */
    @Generated
    protected boolean isWarningLogEnabled() {
        return getSkill(io.sarl.core.Logging.class).isWarningLogEnabled();
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#println(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#println(java.lang.Object).
     */
    @Generated
    protected void println(final Object message) {
        getSkill(io.sarl.core.Logging.class).info(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#setLogLevel(int)}.
     *
     * @see io.sarl.core.Logging#setLogLevel(int).
     */
    @Generated
    protected void setLogLevel(final int level) {
        getSkill(io.sarl.core.Logging.class).setLogLevel(level);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#setLoggingName(java.lang.String)}.
     *
     * @see io.sarl.core.Logging#setLoggingName(java.lang.String).
     */
    @Generated
    protected void setLoggingName(final String message) {
        getSkill(io.sarl.core.Logging.class).setLoggingName(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#warning(java.lang.Object)}.
     *
     * @see io.sarl.core.Logging#warning(java.lang.Object).
     */
    @Generated
    protected void warning(final Object message) {
        getSkill(io.sarl.core.Logging.class).warning(message);
    }

    /**
     * See the capacity {@link io.sarl.core.Logging#warning(java.lang.Object, java.lang.Throwable)}.
     *
     * @see io.sarl.core.Logging#warning(java.lang.Object, java.lang.Throwable).
     */
    @Generated
    protected void warning(final Object message, final Throwable exception) {
        getSkill(io.sarl.core.Logging.class).warning(message, exception);
    }

    @Percept
    public void _handle_Initialize_1(final Initialize occurrence) {
        this.println("Je suis vivant");
    }

    @Percept
    public void _handle_Destroy_2(final Destroy occurrence) {
        this.println("je suis mort");
    }
}

