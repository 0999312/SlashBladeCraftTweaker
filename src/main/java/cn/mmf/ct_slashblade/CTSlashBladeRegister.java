package cn.mmf.ct_slashblade;

import java.util.Arrays;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.recipes.IRecipeAction;
import crafttweaker.api.recipes.IRecipeFunction;
import mods.flammpfeil.slashblade.ItemSlashBladeNamed;
import mods.flammpfeil.slashblade.SlashBlade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper.ShapedPrimer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("flammpfeil.slashblade.SlashBladeRegister")
@ZenRegister
public class CTSlashBladeRegister {
	@ZenMethod
	public static void registerCustomBlade(String name,IItemStack stack) {
		ItemStack itemInput=ItemStack.EMPTY;
		if (stack instanceof IItemStack) {
			itemInput=CraftTweakerMC.getItemStack(stack);
		} 
		if(!(itemInput.isEmpty()))
			Main.addAction(new CustomBladeRegister(name,itemInput));
	}
	@ZenMethod
	public static void registerBladeRecipe(String name, IItemStack output, IItemStack requiredStateBlade, IIngredient[][] ingredients,
			@Optional IRecipeFunction recipeFunction,@Optional IRecipeAction recipeAction, @Optional boolean isMirrored, @Optional boolean isHidden) {
		ItemStack itemInput=ItemStack.EMPTY;
		if (requiredStateBlade instanceof IItemStack) {
			itemInput=CraftTweakerMC.getItemStack(requiredStateBlade);
		} 
		if(!(itemInput.isEmpty()))
			Main.addAction(new RecipeAwakeBladeRegister(name, ingredients, output, itemInput, recipeFunction, recipeAction, isHidden, isHidden));
	}

    private static final class CustomBladeRegister implements IAction {
        private final ItemStack itemInput;
        private final String name;

        private CustomBladeRegister(String name,ItemStack itemInput) {
        	this.name = name;
            this.itemInput = itemInput;
        }

        @Override
        public void apply() {
	        SlashBlade.registerCustomItemStack(name, itemInput);
	        ItemSlashBladeNamed.NamedBlades.add(name);
        }

        @Override
        public String describe(){
            return "Adding a Custom Blade to Slashblade["+name+"]";
        }
    }
    private static final class RecipeAwakeBladeRegister implements IAction {
        private final IItemStack itemOutput;
        private final ItemStack inputBlade;
        private final String name;
        private final IIngredient[][] recipe;
        private final boolean isMirrored;
        protected final IRecipeFunction recipeFunction;
        protected final IRecipeAction recipeAction;
        protected final boolean hidden;
        private RecipeAwakeBladeRegister(String name,IIngredient[][] ingredients, IItemStack output, ItemStack requiredStateBlade,
        		IRecipeFunction recipeFunction,IRecipeAction recipeAction, boolean isMirrored, boolean isHidden) {
        	this.name = name;
            this.itemOutput = output;
            this.inputBlade = requiredStateBlade;
            this.recipeFunction = recipeFunction;
            this.recipeAction = recipeAction;
            this.hidden = isHidden;
            this.recipe = ingredients;
            this.isMirrored = isMirrored;
        }

        @Override
        public void apply() {
        	ForgeRegistries.RECIPES.register(new RecipeCTAwakeBlade(recipe, itemOutput, inputBlade, recipeFunction, recipeAction, isMirrored, hidden).setRegistryName(new ResourceLocation("crafttweaker", name)));
        }

        @Override
        public String describe(){
            return "Adding a RecipeAwakeBlade to Slashblade["+name+"]";
        }
        
        private ShapedPrimer RecipeToShape(IIngredient[][] recipe) {
        	ShapedPrimer ret = new ShapedPrimer();
        	ret.input = createIngredientList(recipe);
        	ret.height = recipe.length;
        	ret.mirrored = false;
            int width = 0;
            for(IIngredient[] ingredientLine : recipe) {
                width = Math.max(width, ingredientLine.length);
            }
            for(int index = 0; index < recipe.length; index++) {
                if(recipe[index].length < width)
                	recipe[index] = Arrays.copyOf(recipe[index], width);
            }
            ret.width = width;
			return ret;
		}
        
        private NonNullList<Ingredient> createIngredientList(IIngredient[][] ingredients) {
            int height = ingredients.length;
            int width = 0;
            for(IIngredient[] ingredientLine : ingredients) {
                width = Math.max(width, ingredientLine.length);
            }

            NonNullList<Ingredient> ingredientList = NonNullList.withSize(width * height, Ingredient.EMPTY);
            for(int row = 0; row < ingredients.length; row++) {
                for(int column = 0; column < ingredients[row].length; column++) {
                    if(ingredients[row][column] != null)
                        ingredientList.set(row * width + column, CraftTweakerMC.getIngredient(ingredients[row][column]));
                }
            }
            return ingredientList;
        }

    }
}
