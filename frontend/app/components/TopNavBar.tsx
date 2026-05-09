import Image from "next/image";
import Link from "next/link";

export function TopNavBar() {
  return (
    <header className="sticky top-0 h-20 bg-green-200">
      <nav
        aria-label={"Top NavBar"}
        className="flex items-center justify-between h-full px-4"
      >
        <div className="flex items-center gap-3">
          <Image
            className="object-contain"
            src="/alien.svg"
            alt="Alien Logo"
            width={48}
            height={48}
            priority
          />
          <Link href="/homepage" className="font-roboto font-bold text-2xl">
            Supaplace
          </Link>
        </div>

        <div>
          <ul></ul>
        </div>

        <div className="flex gap-6">
          <button className="p-3 px-8 rounded-4xl w-auto bg-black text-white">
            <Link href="/login">Login</Link>
          </button>
          <button className="p-3 px-8 rounded-4xl w-auto bg-white text-black">
            <Link href="/register">Register</Link>
          </button>
        </div>
      </nav>
    </header>
  );
}
