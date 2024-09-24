interface Response {
  message: string;
  success: string;
}

export const rememberAccount = async (email: string): Promise<Response> => {
  try {
    const response = await fetch(
      `http://localhost:8080/user/email?email=${email}`, {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      }
    );
    
    if (response.ok) {
      const data = await response.json();
      return data;
    } else {
      return { message: 'Usuário não encontrado!', success: "false" };
    }
  } catch (error) {
    return { message: 'Erro ao lembrar usuário!', success: "false" };
  }
};
