interface Response {
  message: string;
  success: string;
}

export const viewuser = async (
  id: string
): Promise<Response> => {
  try {
    const response = await fetch(`http://localhost:8080/user/id?id=${id}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
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
