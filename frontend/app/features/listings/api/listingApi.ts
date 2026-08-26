const API_URL = process.env.NEXT_PUBLIC_API_URL;

export const fetchListings = async () => {
  const response = await fetch(`${API_URL}/listings`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });

  console.log("Does this work??");

  if (response.ok) {
    return await response.json();
  }
};
