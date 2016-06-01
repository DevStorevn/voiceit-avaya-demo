package flow;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: (timestamp generation disabled)
 */
public class ClearEnrollments extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public ClearEnrollments() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JUN-01  04:36:54 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Clear_Enrollments_Success", "Success");
		next.setDebugId(540);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-JUN-01  04:36:54 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-JUN-01  04:36:54 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(5);
		actions.add(new com.avaya.sce.runtime.varoperations.ResetCollection("EnrollmentRefresh").setDebugId(533));
		actions.add(new com.avaya.sce.runtime.varoperations.NextInCollection("EnrollmentRefresh").setDebugId(711));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		for(com.avaya.sce.runtime.VarCollIterator varCollIterator0=(com.avaya.sce.runtime.VarCollIterator)new com.avaya.sce.runtime.VarCollIterator().setDebugId(534);varCollIterator0.hasNext(mySession, "EnrollmentRefresh");varCollIterator0.next()){
			try {
				actions = new java.util.ArrayList(1);

				//{{START:CODEGEN:EXTENSIONPOINT:com.voiceit_tech.od.plugins.deleteEnrollment
				actions.add(new com.voiceit_tech.od.runtime.DeleteEnrollment("VoiceItDeleteEnrollment", "demoEmail", "demoPassword", "EnrollmentRefresh:EnrollmentID").setDebugId(698));
				//}}END:CODEGEN:EXTENSIONPOINT:com.voiceit_tech.od.plugins.deleteEnrollment

				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			} catch (Exception e1) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.CaptureException(e1).setDebugId(-1));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "VoiceItDeleteEnrollment:IsSuccess", com.avaya.sce.runtime.Expression.IS_FALSE).setDebugId(538)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("General_Error", "Failed").setDebugId(539));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Size("enrollmentCount", "Enroll_Passphrase").setDebugId(705));
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "", "enrollmentCount").setDebugId(706));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		actions = new java.util.ArrayList(1);
		actions.add(new com.avaya.sce.runtime.varoperations.EmptyCollection("VoiceItEnrollments").setDebugId(738));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
