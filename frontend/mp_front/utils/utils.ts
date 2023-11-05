import * as auth from "@/utils/auth";
import { mainApi } from "./MainApi";

export async function registration(firstName: string, email: string, password: string) {   //регистрация
    const response = await auth.register(firstName, email, password)
    if (response.message) {
        return { success: false, error: response.message };

    } else {
        await login(email, password);
        return { success: true, user: response };
    }
}

export async function login(email: string, password: string) {              //вход
    const response = await auth.authorize(email, password)
    if (response.message) {
        return { success: false, error: response.message };

    } else {
        localStorage.setItem("token", response.access_token);       //добавляем токен в хранилище
        return { success: true, token: response.access_token };
    }
}

export async function createItem(name: string, price: string, link?: string) {   //создание товара
    const response = await mainApi.createItem(name,price,link);
    if (response.message) {
        return { error: response.message };

    } else {
        return { item: response };
    }
}

export async function getItems() {
    const response = await mainApi.getItems();
    if (response.message) {
        return { error: response.message };

    } else {
        return { items: response };
    }
}

export async function getItemCategories() {                //получение категорий
    const response = await mainApi.getCategories();
    if (response.message) {
        return { error: response.message };

    } else {
        return { items: response };
    }
}

export async function deleteItem(itemId: string) {
    console.log("АЙДИ: ", itemId, typeof itemId);
    const response = await mainApi.deleteItem(String(itemId));
    console.log("удаление: ", response);
    if (response.message) {
        return { error: response.message };

    } else {
        return { items: response };
    }
}

export const checkForError = (res: any) => {
    if (res.ok) {
        return res.json()
    }
    return Promise.reject(`Ошибка: ${res.status}`);
}