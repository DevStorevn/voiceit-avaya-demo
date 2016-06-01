/**
 * Last generated by Orchestration Designer at: (timestamp generation disabled)
 */
package english.prompts;

public class Enroll_Passphrase extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for Enroll_Passphrase.
	 */
	public Enroll_Passphrase() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: 2016-JUN-01  02:26:50 PM
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("Enroll_Passphrase");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,5000);
		setBargin(1,true);

		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"Demo:Enroll",false));

		format = new com.avaya.sce.runtime.Format();
		format.add("time","500ms");
		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_FULL,"break", format));

		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"Demo:Passphrase",false));

	}
}
