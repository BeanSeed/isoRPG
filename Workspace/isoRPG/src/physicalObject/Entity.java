package physicalObject;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Entity {
	//This modelBuilder is used by all entities in the game.
	private static ModelBuilder modelBuilder = new ModelBuilder();
	
	//Entities have models, this is what they look like in the game
	private Model model;
	//Entities have an model instance
	//A model instance is the description of where the model physically resides in the game
	public ModelInstance instance;
	
	//Constructors with a bunch of different overloads
	public Entity() {
		//No model was passed so create a generic model
		//Model will be placed in <0,0,0> location.
		model = modelBuilder.createBox(5f, 5f, 5f,
				new Material(ColorAttribute.createDiffuse(Color.BLUE)),
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
	}
	public Entity(int x, int y)
	{
		model = modelBuilder.createBox(5f, 5f, 5f,
				new Material(ColorAttribute.createDiffuse(Color.BLUE)),
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
		instance.transform.setToTranslation(x, y, 0);
	}	
	public Entity(int x, int y, Model newModel)
	{
		initModel(newModel);
		instance.transform.setToTranslation(x, y, 0);
		
	}
	public Entity(Vector2 vec, Model newModel)
	{
		initModel(newModel);
		instance.transform.setToTranslation(vec.x,vec.y,0);
	}
	public Entity(Vector3 vec, Model newModel) {
		initModel(newModel);
		instance.transform.setToTranslation(vec);
	}
	public Entity(int x, int y, int z, Model newModel) {
		initModel(newModel);
		instance.transform.setToTranslation(x, y, z);
	}
	
	//Stuff to change the variables
	private void initModel(Model newModel) {
		model = modelBuilder.createBox(5f, 5f, 5f,
				new Material(ColorAttribute.createDiffuse(Color.BLUE)),
				Usage.Position | Usage.Normal);
		instance = new ModelInstance(model);
	}
	@SuppressWarnings(value = { "unused" })
	private void setModel(Model newModel) {
		model = newModel;
		instance = new ModelInstance(model);
	}
}
