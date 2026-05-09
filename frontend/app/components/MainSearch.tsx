export function MainSearch() {
  return (
    <section
      className="relative py-40 flex items-center justify-center border-b-2 bg-cover bg-center bg-no-repeat"
      style={{ backgroundImage: "url('/students.png')" }}
    >
      <div className="absolute inset-0 bg-black/50"></div>

      <div className="relative z-10 flex flex-col gap-10 items-center w-10/12 px-10">
        <label
          className="font-roboto text-6xl text-white text-center"
          htmlFor="searchBar"
        >
          What are you looking for?
        </label>
        <input
          id="searchBar"
          type="search"
          placeholder="Tutoring"
          className="p-5 border-2 rounded-full w-full text-black bg-white outline-none focus:ring-1 focus:ring-green-400"
        />
      </div>
    </section>
  );
}
