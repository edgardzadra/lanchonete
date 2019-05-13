import { Ingredient } from './Ingredient';

export interface LanchePadrao {
    description: string;
    ingredients: Ingredient[];
    totalAmount: number;
}
