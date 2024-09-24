interface Response {
  message: string;
  success: string;
}

export const updateuser = async (
  nome: string,
  email: string,
  senha: string,
): Promise<Response> => {
  try {
    const response = await fetch('http://localhost:8080/user/update', {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ nome, email, senha }),
    });

    if (response.ok) {
      const data = await response.json();
      return data;
    } else {
      return { message: "Credenciais inválidas!", success: "false" };
    }
  } catch (error) {
    return {
      message: "Erro ao fazer login. Tente novamente mais tarde!",
      success: "false",
    };
  }
};
