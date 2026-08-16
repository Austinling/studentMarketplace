import { Search } from "lucide-react";

export function MainSearch() {
  return (
    <div className="relative z-10 flex gap-2 items-center p-3 border-2 rounded-full w-full text-black bg-white ">
      <Search />
      <input
        id="searchBar"
        type="search"
        placeholder="Tutoring"
        className=" outline-none w-full"
      />
    </div>
  );
}
