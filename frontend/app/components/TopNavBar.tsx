import Image from "next/image";

export function TopNavBar() {
  return (
    <header className="sticky top-0 h-20 bg-green-200">
      <nav
        aria-label={"Top NavBar"}
        className="flex items-center justify-between"
      >
        <div className="flex items-center justify-center">
          <Image
            className=""
            src="/alien.svg"
            alt="Alien Logo"
            width={40}
            height={40}
            priority
          />
        </div>
      </nav>
    </header>
  );
}
