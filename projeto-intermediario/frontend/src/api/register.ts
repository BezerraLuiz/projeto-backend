interface Response {
  message: string;
  success: string;
}

export const register = async (
  nome: string,
  email: string,
  senha: string
): Promise<Response> => {
  try {
    const response = await fetch("http://localhost:8080/user/create", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ nome, email, senha }),
    });

    if (response.ok) {
      const data = await response.json();
      return data;
    } else {
      return { message: "Usuário já existente", success: "false" };
    }
  } catch (error) {
    return { message: "Não foi possível criar o usuário!" + error, success: "false" };
  }
};
