import { useQuery } from "@tanstack/react-query";
import { fetchListings } from "../api/listingApi";

export function useListing() {
  return useQuery({
    queryKey: ["listings"],
    queryFn: fetchListings,
  });
}
