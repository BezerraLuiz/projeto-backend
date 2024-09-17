interface LoginError {
  message: string;
}

export const login = async (email: string, senha: string): Promise<LoginError> => {
  try {
    const response = await fetch("http://localhost:8080/login/verify", {
      method: 'POST',
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ email, senha }),
    });

    if (response.ok) {
      const data = await response.json();
      return data;
    } else {
      const errorData: LoginError = { message: "Credenciais inválidas" };
      return errorData;
    }
  } catch (error) {
    const errorData: LoginError = { message: "Erro ao fazer login. Tente novamente mais tarde." };
    return errorData;
  }
}
