const API_URL = process.env.NEXT_PUBLIC_API_URL;

export const fetchListings = async () => {
  console.log("Api URL", API_URL);
  const response = await fetch(`${API_URL}/listings`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  });

  console.log("Does this do omething?");

  if (response.ok) {
    console.log("Does this do something?");
    return await response.json();
  }
};
