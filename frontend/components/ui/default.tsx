import { TopNavBar } from "@/app/features/auth/components/TopNavBar";

export function Page({ children }: { children: React.ReactNode }) {
  return (
    <main className="flex flex-col h-full">
      <TopNavBar />
      {children}
    </main>
  );
}
